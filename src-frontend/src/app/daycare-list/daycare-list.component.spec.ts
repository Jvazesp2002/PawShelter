import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DaycareListComponent } from './daycare-list.component';

describe('DaycareListComponent', () => {
  let component: DaycareListComponent;
  let fixture: ComponentFixture<DaycareListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DaycareListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DaycareListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
