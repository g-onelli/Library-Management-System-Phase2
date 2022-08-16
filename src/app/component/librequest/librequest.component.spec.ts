import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrequestComponent } from './librequest.component';

describe('LibrequestComponent', () => {
  let component: LibrequestComponent;
  let fixture: ComponentFixture<LibrequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibrequestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
