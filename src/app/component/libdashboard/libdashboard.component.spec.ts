import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibdashboardComponent } from './libdashboard.component';

describe('LibdashboardComponent', () => {
  let component: LibdashboardComponent;
  let fixture: ComponentFixture<LibdashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibdashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
