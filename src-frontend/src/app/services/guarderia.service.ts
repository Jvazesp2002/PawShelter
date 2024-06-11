import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MascotaGuar } from '../model/mascota-guar';
@Injectable({
  providedIn: 'root'
})
export class GuarderiaService {
  private apiUrl = 'http://localhost:8080/api/guarderia';

  constructor(private http: HttpClient) {}

  getDogVaccinations(): Observable<MascotaGuar[]> {
    return this.http.get<MascotaGuar[]>(this.apiUrl);
  }

  createDogVaccination(mascotaGuar: MascotaGuar): Observable<MascotaGuar> {
    return this.http.post<MascotaGuar>(this.apiUrl, mascotaGuar);
  }

  updateDogVaccination(id: number, mascotaGuar: MascotaGuar): Observable<MascotaGuar> {
    return this.http.put<MascotaGuar>(`${this.apiUrl}/${id}`, mascotaGuar);
  }

  deleteDogVaccination(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
