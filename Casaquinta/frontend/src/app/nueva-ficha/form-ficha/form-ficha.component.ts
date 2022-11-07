import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Form , FormBuilder} from '@angular/forms';
import { FormControl } from '@angular/forms';
import { Ficha_clinica } from 'src/app/models/Ficha_clinica';
import { SesionService } from 'src/app/services/sesion/sesion.service';
import * as moment from 'moment';

@Component({
  selector: 'app-form-ficha',
  templateUrl: './form-ficha.component.html',
  styleUrls: ['./form-ficha.component.css']
})
export class FormFichaComponent implements OnInit{
  formficha:FormGroup;
  date = new FormControl(moment().utcOffset(-240).format());
  date1 = new FormControl(moment().utcOffset(-240).format());
  escolaridades: {
    id_escolaridad: number;
    nivel: string;
  }[] = [
    {
      id_escolaridad: 1,
      nivel: 'Preescolar'
    },
    {
      id_escolaridad: 2,
      nivel: 'Básica'
    },
    {
      id_escolaridad: 3,
      nivel: 'Media'
    },
    {
      id_escolaridad: 4,
      nivel: 'Superior'
    }

  ];
  
  constructor(private fb: FormBuilder, private service:SesionService){

    this.formficha = fb.group({

      nombre : fb.control(''),
      apellidos : fb.control(''),
      rut : fb.control(''),
      direccion : fb.control(''),
      comuna : fb.control(''),
      telefono : fb.control(''),
      correo : fb.control(''),
      tutor : fb.control(''),
      parentesco : fb.control(''),
      escolaridad : fb.control(''),

    });
  }

  ngOnInit() {
    console.log("Hola");
  }

  registar(){

    const resultado = {
      nombres: this.formficha.value.nombre,
      apellido: this.formficha.value.apellidos,
      rut: this.formficha.value.rut,
      correo: this.formficha.value.correo,
      fechaIngreso: this.date,
      fechaNacimiento: this.date1,
      escolaridad:this.formficha.value.escolaridad,
    };
    console.log(resultado);

    let fecha = this.date.value;
    let fecha1 = this.date1.value;
    if (fecha == null)
    {
      fecha = moment().utcOffset(-240).format();
    }
    
    if (fecha1 == null)
    {
      fecha1 = moment().utcOffset(-240).format();
    }


      let ficha = new Ficha_clinica();
      ficha.rut = Number.parseInt(`${this.formficha.value.rut}`);
      ficha.nombre = `${this.formficha.value.nombre}`;
      ficha.apellido = `${this.formficha.value.apellidos}`;
      ficha.correo = `${this.formficha.value.correo}`;
      ficha.telefono = `${this.formficha.value.telefono}`;
      ficha.comuna = `${this.formficha.value.comuna}`;
      ficha.direccion = `${this.formficha.value.direccion}`;
      ficha.tutor = `${this.formficha.value.tutor}`;
      ficha.parentesco = `${this.formficha.value.parentesco}`;
      ficha.nivel_escolaridad = `${this.formficha.value.escolaridad}`;
      ficha.fecha_ingreso = fecha;
      ficha.fecha_nacimiento = fecha1;

      console.log(ficha);
      this.service.postFicha(ficha).subscribe();
    
  }




}
