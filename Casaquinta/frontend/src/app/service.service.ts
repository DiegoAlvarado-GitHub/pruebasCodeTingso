import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sesion } from './models/Sesion';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }
  getSesion(){
    return this.http.get<Sesion[]>("http://localhost:8080/api/sesion");
  }
}
