import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CropSellComponent } from './crop-sell.component';

describe('CropSellComponent', () => {
  let component: CropSellComponent;
  let fixture: ComponentFixture<CropSellComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CropSellComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CropSellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
