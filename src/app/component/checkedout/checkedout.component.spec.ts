import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckedoutComponent } from './checkedout.component';

describe('CheckedoutComponent', () => {
  let component: CheckedoutComponent;
  let fixture: ComponentFixture<CheckedoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckedoutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckedoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
