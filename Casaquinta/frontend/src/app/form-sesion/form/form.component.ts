import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import * as moment from 'moment';
import { Sesion } from 'src/app/models/Sesion';
import { Terapia } from 'src/app/models/Terapia';
import { SesionService } from 'src/app/services/sesion/sesion.service'; 
import { Router } from '@angular/router';
import { ActivatedRoute  } from '@angular/router';


let id_Usuario = 202259650;
let nombre_profesional = "Roberto";


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit{
  id_ficha = 0;
  formSesion = new FormGroup({
    privada : new FormControl('',[Validators.required, Validators.nullValidator]),
    fecha : new FormControl('',[Validators.required, Validators.nullValidator]),
    terapia : new FormControl('',[Validators.required, Validators.nullValidator]),
    objetivoActividad : new FormControl('',[Validators.required, Validators.nullValidator]),
    indicaciones : new FormControl('',[Validators.required, Validators.nullValidator]),
    observaciones : new FormControl('',[Validators.required, Validators.nullValidator]),
    formatoSesion : new FormControl('true',[Validators.required, Validators.nullValidator]),
    acompanamiento : new FormControl('true',[Validators.required, Validators.nullValidator]),
  });


  // privada = new FormControl('',{nonNullable: true});
  date = new FormControl(new Date());
  serializedDate = new FormControl(moment().utcOffset(-240).format());



 
  terapias:Terapia[];
  constructor(private service:SesionService,private route: ActivatedRoute, private router: Router)  { 
    this.terapias = [];
  }

  ngOnInit(){
    this.id_ficha = Number.parseInt(`${this.route.snapshot.paramMap.get('id_ficha')}`);
    this.service.getTerapiasDelUsuario(id_Usuario).subscribe(data => {
      this.terapias=data;
    });
  }

  registar(){

    let fecha = this.serializedDate.value;
    // let privada = this.privada.value;
    if (this.formSesion.value.privada == '')
    {
      this.formSesion.value.privada = 'false';
    }
    if (fecha == null)
    {
      fecha = moment().utcOffset(-240).format();
    }

  
    const profesional = "Jaqueline";
    const idTerapia =  Number.parseInt(`${this.formSesion.value.terapia}`);
    

    const tipoSesion =`${this.terapias.find(e => e.id == idTerapia)?.tipo_terapia}`;
    const sesion = new Sesion();
    sesion.fecha = fecha; 
    sesion.indicacion_cuidadores= `${this.formSesion.value.indicaciones}`; 
    sesion.objetivo_actividad= `${this.formSesion.value.objetivoActividad}`;
    sesion.observaciones=  `${this.formSesion.value.observaciones}`; 
    sesion.privada= `${this.formSesion.value.privada}`; 
    sesion.profesional= nombre_profesional; 
    sesion.tipo_sesion= tipoSesion;
    sesion.formato_presencial= `${this.formSesion.value.formatoSesion}`; 
    sesion.acompanado = `${this.formSesion.value.acompanamiento}`; 
  
    //Para poder realizar la publicacion de la sesion se requiere haber rellenado el tipo de terapia
    if (sesion.tipo_sesion == "undefined"){
      window.alert("Debe seleccionar una Terapia para continuar");  
    }
    //caso se puede publicar una sesion. Finalizado esto se redirige a la ficha clinica del paciente
    else{
      window.alert("Sesión creada exitosamente");
      this.service.postSesion(sesion, idTerapia, this.id_ficha).subscribe();
      this.router.navigateByUrl(`/sesion/${this.id_ficha}`)    
    }


    

  }


  

  }


//Terapias que se mostraran en "form.component.html" --> se iterean mediante for
//  terapias: {
//   id: number;
//   name: string;
// }[] = [
//   {
//     id: 1,
//     name: 'terapia 1'
//   },
//   {
//     id: 2,
//     name: 'terapia 2'
//   },
//   {
//     id: 3,
//     name: 'terapia 3'
//   },
//   {
//     id: 4,
//     name: 'dupla'
//   },
// ];