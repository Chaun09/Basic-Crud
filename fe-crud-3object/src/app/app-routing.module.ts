import { SubtaskComponent } from './layout/subtask/subtask.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StatusComponent } from '../app/layout/status/status.component';
import { TaskComponent } from './layout/task/task.component';
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
  {
    path: 'task',
    component: TaskComponent,
  },
  {
    path: 'subtask',
    component: SubtaskComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
