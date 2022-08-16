import { TestBed } from '@angular/core/testing';

import { AvailablebooksService } from './availablebooks.service';

describe('AvailablebooksService', () => {
  let service: AvailablebooksService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AvailablebooksService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
