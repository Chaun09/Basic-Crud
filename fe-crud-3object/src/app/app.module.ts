import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StatusComponent } from './layout/status/status.component';
import { TaskComponent } from './layout/task/task.component';
import { SubtaskComponent } from './layout/subtask/subtask.component';

@NgModule({
  declarations: [
    AppComponent,
    StatusComponent,
    TaskComponent,
    SubtaskComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
