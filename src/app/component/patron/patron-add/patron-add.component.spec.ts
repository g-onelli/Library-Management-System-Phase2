import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatronAddComponent } from './patron-add.component';

describe('PatronAddComponent', () => {
  let component: PatronAddComponent;
  let fixture: ComponentFixture<PatronAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatronAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatronAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
