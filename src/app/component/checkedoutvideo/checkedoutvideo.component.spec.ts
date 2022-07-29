import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckedoutvideoComponent } from './checkedoutvideo.component';

describe('CheckedoutvideoComponent', () => {
  let component: CheckedoutvideoComponent;
  let fixture: ComponentFixture<CheckedoutvideoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckedoutvideoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckedoutvideoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
