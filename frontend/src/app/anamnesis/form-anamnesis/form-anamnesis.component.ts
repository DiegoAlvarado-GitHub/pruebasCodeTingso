import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Form , FormBuilder} from '@angular/forms';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-form-anamnesis',
  templateUrl: './form-anamnesis.component.html',
  styleUrls: ['./form-anamnesis.component.css']
})
export class FormAnamnesisComponent implements OnInit{
  formanamnesis:FormGroup;
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
  
  constructor(private fb: FormBuilder){
    this.formanamnesis = fb.group({

      nombreCompleto : fb.control(''),
      rut : fb.control(''),
      nacionalidad: fb.control(''),
      informante : fb.control(''),
      parentesco : fb.control(''),
      direccion : fb.control(''),
      comuna : fb.control(''),
      correo : fb.control(''),
      contacto : fb.control(''),
      escolaridad : fb.control(''),

    });
  }

  ngOnInit() {
    

  }

  registar(){

    const resultado = {
      nombres: this.formanamnesis.value.nombre,
      apellido: this.formanamnesis.value.apellidos,
      rut: this.formanamnesis.value.rut,
      correo: this.formanamnesis.value.correo,
      fechaIngreso: this.date,
      fechaNacimiento: this.date1,
    };
    console.log(resultado);
  }

  date = new FormControl(new Date());
  date1 = new FormControl(new Date());
}