import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatdashboardComponent } from './patdashboard.component';

describe('PatdashboardComponent', () => {
  let component: PatdashboardComponent;
  let fixture: ComponentFixture<PatdashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatdashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
