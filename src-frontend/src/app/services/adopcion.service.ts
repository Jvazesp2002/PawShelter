import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MascotaAdop } from '../model/mascota-adop';

@Injectable({
  providedIn: 'root'
})
export class AdopcionService {
  private apiUrl = 'http://localhost:8080/api/refugio';

  constructor(private http: HttpClient) {}

  getDogVaccinations(): Observable<MascotaAdop[]> {
    return this.http.get<MascotaAdop[]>(this.apiUrl);
  }

  createDogVaccination(mascotaAdop: MascotaAdop): Observable<MascotaAdop> {
    return this.http.post<MascotaAdop>(this.apiUrl, mascotaAdop);
  }

  updateDogVaccination(id: number, mascotaAdop: MascotaAdop): Observable<MascotaAdop> {
    return this.http.put<MascotaAdop>(`${this.apiUrl}/${id}`, mascotaAdop);
  }

  deleteDogVaccination(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
