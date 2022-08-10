import { TestBed } from '@angular/core/testing';

import { AvailablevideosService } from './availablevideos.service';

describe('AvailablevideosService', () => {
  let service: AvailablevideosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AvailablevideosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
