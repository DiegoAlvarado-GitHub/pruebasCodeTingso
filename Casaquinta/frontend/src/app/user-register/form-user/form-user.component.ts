import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl,FormGroup, Validators } from '@angular/forms';
import { Terapia } from 'src/app/models/Terapia';
import { Rol } from 'src/app/models/Rol';
import { SesionService } from 'src/app/services/sesion/sesion.service'; 
import { Usuario } from 'src/app/models/Usuario';




@Component({
  selector: 'app-form-user',
  templateUrl: './form-user.component.html',
  styleUrls: ['./form-user.component.css']
})
export class FormUserComponent implements OnInit{

  rol:FormControl;
  formUsuario = new FormGroup({
    nombre : new FormControl('',[Validators.required, Validators.nullValidator]),
    apellidos : new FormControl('',[Validators.required, Validators.nullValidator]),
    rut : new FormControl('',[Validators.required, Validators.nullValidator]),
    correo : new FormControl('',[Validators.required, Validators.nullValidator])
  });
  formTerapias = new FormArray([new FormControl('')]);
  loadingTerapias: boolean;
  loadingRoles: boolean;

  
  terapias:Terapia[];
  roles:Rol[];
  constructor(private service:SesionService)  { 
    this.terapias = [];
    this.roles = [];
    this.loadingTerapias = true;
    this.loadingRoles = true;
    this.rol = new FormControl('',[Validators.required, Validators.nullValidator]);
  }



  
    ngOnInit(): void {
      this.service.getTerapia().subscribe(data => {
        this.terapias=data;
        if(this.terapias.length == 0){
          this.loadingTerapias = false;
        }
        for (let i = 1; i < this.terapias.length; i++) {
          this.formTerapias.insert(i,new FormControl(''));    
        }
      });

      this.service.getRoles().subscribe(data =>{
        this.roles = data;
        if(this.roles.length == 0){
          this.loadingRoles = false;
        }
        this.rol.setValue(data[0].id);
        // this.formUsuario.setValue();
      })
    }

    onSubmit() {
      const form = this.formUsuario.value;
      let terapiasImpartidas:Terapia[];
      terapiasImpartidas =[];
      this.terapias.forEach((e,i)=>{
        if(this.formTerapias.value[i] != ''){

          terapiasImpartidas.push(e);
        }
      });

      if(form.nombre == "" || form.apellidos =="" || form.correo == "" || form.rut == "" || this.rol.value == null){
        window.alert("Ingrese todos los campos antes de continuar");
      }

      else{
        let usuario = new Usuario();
        usuario.id = Number.parseInt(`${form.rut}`);
        usuario.nombre = `${form.nombre}`;
        usuario.apellidos = `${form.apellidos}`;
        usuario.correo = `${form.correo}`;
        usuario.especialidad = `${terapiasImpartidas[0].tipo_terapia}`;
        usuario.password = `${form.rut}`;
        usuario.terapias = terapiasImpartidas;
        let indexRol = Number.parseInt(this.rol.value == null ? `${this.roles[0].id}` : this.rol.value);
        this.service.postUsuario(usuario,this.rol.value).subscribe();
        window.alert("Usuario creado exitosamente");
      }

      

      
      

      
    }
  }

  



  
  
