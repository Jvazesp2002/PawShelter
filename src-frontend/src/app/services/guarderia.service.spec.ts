import { TestBed } from '@angular/core/testing';

import { GuarderiaService } from './guarderia.service';

describe('GuarderiaService', () => {
  let service: GuarderiaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuarderiaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
