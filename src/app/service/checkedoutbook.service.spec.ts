import { TestBed } from '@angular/core/testing';

import { CheckedoutbookService } from './checkedoutbook.service';

describe('CheckedoutbookService', () => {
  let service: CheckedoutbookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CheckedoutbookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
