import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CropDetailsComponent } from './crop-details.component';

describe('CropDetailsComponent', () => {
  let component: CropDetailsComponent;
  let fixture: ComponentFixture<CropDetailsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CropDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CropDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
