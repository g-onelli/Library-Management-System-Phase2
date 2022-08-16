import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroomComponent } from './libroom.component';

describe('LibroomComponent', () => {
  let component: LibroomComponent;
  let fixture: ComponentFixture<LibroomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibroomComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
