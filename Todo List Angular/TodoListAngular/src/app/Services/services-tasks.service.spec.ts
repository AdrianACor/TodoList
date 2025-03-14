import { TestBed } from '@angular/core/testing';

import { ServicesTasksService } from './services-tasks.service';

describe('ServicesTasksService', () => {
  let service: ServicesTasksService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicesTasksService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
