import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventAddUpdateComponent } from './event-add-update.component';

describe('EventAddUpdateComponent', () => {
  let component: EventAddUpdateComponent;
  let fixture: ComponentFixture<EventAddUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventAddUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EventAddUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
