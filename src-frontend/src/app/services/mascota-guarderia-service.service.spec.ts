import { TestBed } from '@angular/core/testing';

import { MascotaGuarderiaServiceService } from './mascota-guarderia-service.service';

describe('MascotaGuarderiaServiceService', () => {
  let service: MascotaGuarderiaServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MascotaGuarderiaServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});