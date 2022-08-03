import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatronDeleteComponent } from './patron-delete.component';

describe('PatronDeleteComponent', () => {
  let component: PatronDeleteComponent;
  let fixture: ComponentFixture<PatronDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatronDeleteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatronDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
