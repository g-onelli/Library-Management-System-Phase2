import { TestBed } from '@angular/core/testing';

import { CheckedoutService } from './checkedout.service';

describe('CheckedoutService', () => {
  let service: CheckedoutService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CheckedoutService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
