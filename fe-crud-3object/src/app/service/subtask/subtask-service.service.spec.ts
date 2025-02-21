import { TestBed } from '@angular/core/testing';

import { SubtaskServiceService } from './subtask-service.service';

describe('SubtaskServiceService', () => {
  let service: SubtaskServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubtaskServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
