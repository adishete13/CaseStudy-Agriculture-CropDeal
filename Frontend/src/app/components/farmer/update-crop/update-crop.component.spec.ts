import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { UpdateCropComponent } from './update-crop.component';

describe('UpdateCropComponent', () => {
  let component: UpdateCropComponent;
  let fixture: ComponentFixture<UpdateCropComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateCropComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCropComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
