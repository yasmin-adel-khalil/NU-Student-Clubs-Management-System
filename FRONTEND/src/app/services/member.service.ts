import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  private apiBase = 'http://localhost:8081/api';

  constructor(private http: HttpClient) {}

  getBestMembersByClubAndSeason(clubId: number, season: 'mid' | 'end'): Observable<any[]> {
    const url = `${this.apiBase}/members/club/${clubId}/bests/${season}`;
    return this.http.get<any[]>(url);
  }
}
