import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MascotaGuar } from '../model/mascota-guar';
@Injectable({
  providedIn: 'root'
})
export class GuarderiaService {
  private apiUrl = 'http://localhost:8080/api/guarderia';

  constructor(private http: HttpClient) { }

  getMascotasGuarderia(token: string): Observable<MascotaGuar[]> {
    // Agregar el token de autenticación al encabezado de la solicitud
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    // Configurar las cabeceras CORS para permitir solicitudes desde el origen de tu aplicación Angular
    headers.set('Access-Control-Allow-Origin', 'http://localhost:4200');
    return this.http.get<any[]>(`${this.apiUrl}`, { headers });
  }

  createMascotaGuarderia(mascotaGuar: MascotaGuar, token: string): Observable<any[]> {
    // Agregar el token de autenticación al encabezado de la solicitud
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    // Configurar las cabeceras CORS para permitir solicitudes desde el origen de tu aplicación Angular
    headers.set('Access-Control-Allow-Origin', 'http://localhost:4200');

    // Hacer la solicitud HTTP con el encabezado de autenticación y las cabeceras CORS
    return this.http.post<any[]>(`${this.apiUrl}`, mascotaGuar, { headers });
  }

  updateMascotaGuarderia(id: number, mascotaGuar: MascotaGuar, token: string): Observable<any[]> {
    // Agregar el token de autenticación al encabezado de la solicitud
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    // Configurar las cabeceras CORS para permitir solicitudes desde el origen de tu aplicación Angular
    headers.set('Access-Control-Allow-Origin', 'http://localhost:4200');

    // Hacer la solicitud HTTP con el encabezado de autenticación y las cabeceras CORS
    return this.http.put<any[]>(`${this.apiUrl}/${id}`, mascotaGuar, { headers });
  }

  deleteMascotaGuarderia(id: number, token: string): Observable<void> {
    // Agregar el token de autenticación al encabezado de la solicitud
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    // Configurar las cabeceras CORS para permitir solicitudes desde el origen de tu aplicación Angular
    headers.set('Access-Control-Allow-Origin', 'http://localhost:4200');

    // Realizar la solicitud HTTP DELETE para borrar la mascota
    return this.http.delete<any>(`${this.apiUrl}/${id}`, { headers });
  }
}
