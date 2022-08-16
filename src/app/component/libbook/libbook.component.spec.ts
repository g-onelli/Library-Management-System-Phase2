import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibbookComponent } from './libbook.component';

describe('LibbookComponent', () => {
  let component: LibbookComponent;
  let fixture: ComponentFixture<LibbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibbookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
