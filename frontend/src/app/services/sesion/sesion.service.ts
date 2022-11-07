import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sesion } from 'src/app/models/Sesion';
import { Terapia } from 'src/app/models/Terapia';
import { Rol } from 'src/app/models/Rol';
import { Usuario } from 'src/app/models/Usuario'
import { Ficha_clinica } from 'src/app/models/Ficha_clinica';
@Injectable({
  providedIn: 'root'
})
export class SesionService {

  constructor(private http: HttpClient) { }

  //Sesiones
  postSesion(sesion: Sesion, idTerapia:Number, idFicha:Number){
    return this.http.post<Sesion[]>(`http://localhost:8080/api/sesion/${idTerapia}/${idFicha}`, sesion);
  }

  getSesiones(){
    return this.http.get<Sesion[]>("http://localhost:8080/api/sesion");
  }
  getSesion(idSesion:Number){
    return this.http.get<Sesion>(`http://localhost:8080/api/sesion/${idSesion}`);
  }

  getSesionesFicha(idFicha:Number){
    return this.http.get<Sesion[]>(`http://localhost:8080/api/sesion/ficha/${idFicha}`);
  }

  getEmailOfSesionById(id:Number){
    return this.http.get<Sesion>(`http://localhost:8080/api/sesion/pdf/${id}`);
    
  }

  //Terapia
  getTerapia(){
    return this.http.get<Terapia[]>("http://localhost:8080/api/terapia");
  }

  getTerapiasDelUsuario(id:Number){
    return this.http.get<Terapia[]>(`http://localhost:8080/api/terapia/usuario/${id}`);
  }

  getTerapiasFaltantes(id:Number){
    return this.http.get<Terapia[]>(`http://localhost:8080/api/terapia/faltantes/usuario/${id}`);
  }

  //rol
  getRoles(){
    return this.http.get<Rol[]>("http://localhost:8080/api/rol");
  }

  //usuario
  postUsuario(usuario: Usuario,id:Number){
    return this.http.post<Usuario>(`http://localhost:8080/api/usuario/${id}`,usuario);
  }

  putUsuario(usuario: Usuario,id:Number){
    return this.http.put<Usuario>(`http://localhost:8080/api/usuario/${id}`,usuario);
  }

  putUsuarioPassword(usuario: Usuario,id:Number){
    return this.http.put<Usuario>(`http://localhost:8080/api/usuario/password/${id}`,usuario);
  }

  getUsuario(id:Number){
    return this.http.get<Usuario>( `http://localhost:8080/api/usuario/${id}`);
  }

  // ficha clinica
  getFichasByName(name:String){
    return this.http.get<Ficha_clinica[]>(`http://localhost:8080/api/ficha_clinica/name=${name}`);
  }

  getFichaById(id:Number){
    return this.http.get<Ficha_clinica>(`http://localhost:8080/api/ficha_clinica/${id}`);
  }
  
  getFichaExiste(id:Number){
    return this.http.get<Boolean>(`http://localhost:8080/api/ficha_clinica/existe/${id}`);
  }

  postFicha(ficha:Ficha_clinica){
    return this.http.post<Ficha_clinica>(`http://localhost:8080/api/ficha_clinica/`,ficha);
  }



  

}