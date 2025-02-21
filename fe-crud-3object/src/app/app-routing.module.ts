import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StatusComponent } from '../app/layout/status/status.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/status',
    pathMatch: 'full',
  },
  {
    path: 'status',
    component: StatusComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
