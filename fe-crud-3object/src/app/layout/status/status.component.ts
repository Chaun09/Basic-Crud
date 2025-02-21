import { CssSelector } from '@angular/compiler';
import { Component } from '@angular/core';

@Component({
  selector: 'app-status',
  standalone: false,
  styleUrl: './status.component.scss',
  templateUrl: './status.component.html',
})
export class StatusComponent {
  boolean: boolean = false;
  showForm() {
    this.boolean = true;
  }
  hideForm() {
    this.boolean = false;
  }
}
