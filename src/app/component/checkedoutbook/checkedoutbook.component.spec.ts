import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckedoutbookComponent } from './checkedoutbook.component';

describe('CheckedoutbookComponent', () => {
  let component: CheckedoutbookComponent;
  let fixture: ComponentFixture<CheckedoutbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckedoutbookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckedoutbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
