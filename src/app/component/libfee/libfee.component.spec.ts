import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibfeeComponent } from './libfee.component';

describe('LibfeeComponent', () => {
  let component: LibfeeComponent;
  let fixture: ComponentFixture<LibfeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibfeeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibfeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
