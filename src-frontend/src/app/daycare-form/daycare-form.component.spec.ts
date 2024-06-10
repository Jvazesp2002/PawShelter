import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DaycareFormComponent } from './daycare-form.component';

describe('DaycareFormComponent', () => {
  let component: DaycareFormComponent;
  let fixture: ComponentFixture<DaycareFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DaycareFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DaycareFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
