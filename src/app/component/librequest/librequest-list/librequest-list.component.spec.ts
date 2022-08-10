import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrequestListComponent } from './librequest-list.component';

describe('LibrequestListComponent', () => {
  let component: LibrequestListComponent;
  let fixture: ComponentFixture<LibrequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibrequestListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibrequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
