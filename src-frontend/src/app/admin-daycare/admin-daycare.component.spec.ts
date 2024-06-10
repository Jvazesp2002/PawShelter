import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDaycareComponent } from './admin-daycare.component';

describe('AdminDaycareComponent', () => {
  let component: AdminDaycareComponent;
  let fixture: ComponentFixture<AdminDaycareComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminDaycareComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminDaycareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
