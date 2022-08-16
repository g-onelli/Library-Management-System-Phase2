import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibvideoComponent } from './libvideo.component';

describe('LibvideoComponent', () => {
  let component: LibvideoComponent;
  let fixture: ComponentFixture<LibvideoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibvideoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibvideoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
