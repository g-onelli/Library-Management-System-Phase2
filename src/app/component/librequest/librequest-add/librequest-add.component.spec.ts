import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrequestAddComponent } from './librequest-add.component';

describe('LibrequestAddComponent', () => {
  let component: LibrequestAddComponent;
  let fixture: ComponentFixture<LibrequestAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibrequestAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibrequestAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
