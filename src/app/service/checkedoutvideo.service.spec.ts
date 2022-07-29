import { TestBed } from '@angular/core/testing';

import { CheckedoutvideoService } from './checkedoutvideo.service';

describe('CheckedoutvideoService', () => {
  let service: CheckedoutvideoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CheckedoutvideoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
