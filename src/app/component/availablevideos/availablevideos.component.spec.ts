import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailablevideosComponent } from './availablevideos.component';

describe('AvailablevideosComponent', () => {
  let component: AvailablevideosComponent;
  let fixture: ComponentFixture<AvailablevideosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvailablevideosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AvailablevideosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
