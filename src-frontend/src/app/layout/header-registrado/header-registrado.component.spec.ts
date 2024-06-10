import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderRegistradoComponent } from './header-registrado.component';

describe('HeaderRegistradoComponent', () => {
  let component: HeaderRegistradoComponent;
  let fixture: ComponentFixture<HeaderRegistradoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HeaderRegistradoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HeaderRegistradoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
