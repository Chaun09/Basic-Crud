import { StatusDT } from './../../interfaces/Status.interfaces';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component } from '@angular/core';
import { StatusServiceService } from '../../service/status/status-service.service';

@Component({
  selector: 'app-status',
  standalone: false,
  styleUrl: './status.component.scss',
  templateUrl: './status.component.html',
})
export class StatusComponent {
  constructor(private statusService: StatusServiceService) {}
  Status: StatusDT[] = [];

  boolean: boolean = false;
  updateForm: FormGroup = new FormGroup({
    title: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
  });
  statusForm: FormGroup = new FormGroup({
    title: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
  });
  showForm() {
    this.boolean = true;
  }
  hideForm() {
    this.boolean = false;
  }
  ngOnInit() {
    this.statusService.getAllStatus().subscribe((data) => {
      this.Status = data.content;
      console.log(this.Status);
    });
  }

  deleteStatus(id: number) {
    this.statusService.deleteStatus(id).subscribe((data) => {
      return this.ngOnInit();
    });
  }
  createStatus() {
    this.statusService.createStatus(this.statusForm.value).subscribe((data) => {
      this.ngOnInit();
      this.statusForm.reset();
      this.hideForm();
    });
  }

  updateStatus(id: number) {
    this.statusService
      .updateStatus(this.statusForm.value, id)
      .subscribe((data) => {
        this.ngOnInit();
        this.statusForm.reset();
        this.hideForm();
      });
  }
  status = {
    id: 0,
    title: '',
    description: '',
  };
  getStatusById(id: number) {
    this.statusService.getStatusById(id).subscribe((data) => {
      this.status.id = data.id;
      this.status.title = data.title;
      this.status.description = data.description;
      this.showForm();
    });
  }
}
