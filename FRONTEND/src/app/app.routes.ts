import { Routes } from '@angular/router';
import { BestMembersComponent } from './best-members/best-members.component';

export const routes: Routes = [
  { path: 'best-members', component: BestMembersComponent },
  { path: '', redirectTo: '/best-members', pathMatch: 'full' }
];
