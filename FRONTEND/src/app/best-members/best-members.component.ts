import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { MemberService } from '../services/member.service';

@Component({
  selector: 'app-best-members',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './best-members.component.html',
  styleUrls: ['./best-members.component.css']
})
export class BestMembersComponent implements OnInit, OnDestroy {
  title = 'IEEE NU Student Branch Club';
  committees = ['PR','HR','Operations','Marketing','Media'];
  active: 'mid'|'end' = 'mid';
  bests: Record<string, any[]> = { mid: [], end: [] };
  loading = false;

  private clubId = 1;
  private destroy$ = new Subject<void>();

  // Avatar color palette for member initials
  private colors = ['#FF6B6B', '#4ECDC4', '#45B7D1', '#FFA07A', '#98D8C8', '#F7DC6F', '#BB8FCE', '#85C1E2'];

  constructor(private memberService: MemberService) {}

  ngOnInit(): void {
    this.load(this.active);
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  setSeason(s: 'mid'|'end'){
    this.active = s;
    if(!this.bests[s] || this.bests[s].length === 0){
      this.load(s);
    }
  }

  load(season: 'mid'|'end'){
    this.loading = true;
    console.log('Loading best members for season:', season);
    
    this.memberService.getBestMembersByClubAndSeason(this.clubId, season)
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (data) => {
          console.log('Data received:', data);
          this.bests[season] = Array.isArray(data) ? data : [];
          this.loading = false;
          console.log('Bests updated for', season, ':', this.bests[season]);
        },
        error: (error) => {
          console.error('Failed to load bests for', season, ':', error);
          this.bests[season] = [];
          this.loading = false;
        }
      });
  }

  memberForCommittee(season: 'mid'|'end', committee: string){
    return (this.bests[season] || []).find((m:any) => (m.committee||'').toLowerCase() === committee.toLowerCase()) || null;
  }

  // Generate a stable color for a member based on their name
  getAvatarColor(name: string): string {
    if (!name) return this.colors[0];
    let hash = 0;
    for (let i = 0; i < name.length; i++) {
      hash = name.charCodeAt(i) + ((hash << 5) - hash);
    }
    return this.colors[Math.abs(hash) % this.colors.length];
  }

  // Get member initials for avatar
  getMemberInitials(name: string): string {
    if (!name) return 'M';
    return name.split(' ').map(n => n.charAt(0)).join('').toUpperCase().slice(0, 2);
  }
}
