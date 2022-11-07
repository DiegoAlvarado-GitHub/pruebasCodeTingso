import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { Sesion } from '../models/Sesion';
import { FormControl } from '@angular/forms';

/****************************************************************
*                                                               *
*      SE ESTA UTILIZANDO COMO PRUEBA DE FUNCIONALIDADES        *
*                                                               *
/****************************************************************/
@Component({
  selector: 'app-root',
  templateUrl: './root.component.html',
  styleUrls: ['./root.component.css']
})
export class RootComponent implements OnInit{
  privada = new FormControl('');

  sesion:Sesion[];
  constructor(private service:ServiceService) { 
    this.sesion = [];
    
  }
 ngOnInit(): void {
    this.service.getSesion();
 }
 getSesiones (){
    // this.service.getSesion().subscribe();
    
    // this.service.getSesion().subscribe(resp => {
    //   console.log(resp);
    //   return this.sesion=resp;});
    // console.log(this.sesion);
    // this.checked =!this.checked;

  }  
 

}