import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MascotaAdop } from '../model/mascota-adop';

@Injectable({
  providedIn: 'root'
})
export class AdopcionService {
  private apiUrl = 'http://localhost:8080/api/refugio';

  constructor(private http: HttpClient) { }

  getListaAdopcion(token: string): Observable<MascotaAdop[]> {
    // Agregar el token de autenticación al encabezado de la solicitud
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    // Configurar las cabeceras CORS para permitir solicitudes desde el origen de tu aplicación Angular
    headers.set('Access-Control-Allow-Origin', 'http://localhost:4200');
    return this.http.get<any[]>(`${this.apiUrl}`, { headers });
  }

  createMascotaAdopcion(mascotaAdop: MascotaAdop): Observable<MascotaAdop> {
    return this.http.post<MascotaAdop>(this.apiUrl, mascotaAdop);
  }

  updateMascotaAdopcion(id: number, mascotaAdop: MascotaAdop): Observable<MascotaAdop> {
    return this.http.put<MascotaAdop>(`${this.apiUrl}/${id}`, mascotaAdop);
  }

  deleteMascotaAdopcion(id: number, token: string): Observable<void> {
    // Agregar el token de autenticación al encabezado de la solicitud
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    // Configurar las cabeceras CORS para permitir solicitudes desde el origen de tu aplicación Angular
    headers.set('Access-Control-Allow-Origin', 'http://localhost:4200');

    // Realizar la solicitud HTTP DELETE para borrar la mascota
    return this.http.delete<any>(`${this.apiUrl}/${id}`, { headers });
  }
}
