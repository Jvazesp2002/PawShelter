import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MascotaGuar } from '../model/mascota-guar';
@Injectable({
  providedIn: 'root'
})
export class GuarderiaService {
  private apiUrl = 'http://localhost:8080/api/guarderia';

  constructor(private http: HttpClient) {}

  getMascotasGuarderia(token: string): Observable<MascotaGuar[]> {
        // Agregar el token de autenticación al encabezado de la solicitud
        const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

        // Configurar las cabeceras CORS para permitir solicitudes desde el origen de tu aplicación Angular
        headers.set('Access-Control-Allow-Origin', 'http://localhost:4200');
        return this.http.get<any[]>(`${this.apiUrl}`, { headers });
  }

  createMascotaGuarderia(mascotaGuar: MascotaGuar): Observable<MascotaGuar> {
    return this.http.post<MascotaGuar>(this.apiUrl, mascotaGuar);
  }

  updateMascotaGuarderia(id: number, mascotaGuar: MascotaGuar): Observable<MascotaGuar> {
    return this.http.put<MascotaGuar>(`${this.apiUrl}/${id}`, mascotaGuar);
  }

  deleteMascotaGuarderia(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
