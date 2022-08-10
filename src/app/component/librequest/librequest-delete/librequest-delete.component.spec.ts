import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrequestDeleteComponent } from './librequest-delete.component';

describe('LibrequestDeleteComponent', () => {
  let component: LibrequestDeleteComponent;
  let fixture: ComponentFixture<LibrequestDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibrequestDeleteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibrequestDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
