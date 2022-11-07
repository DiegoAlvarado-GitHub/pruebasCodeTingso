import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl,FormGroup, Validators } from '@angular/forms';
import { Terapia } from 'src/app/models/Terapia';
import { Rol } from 'src/app/models/Rol';
import { SesionService } from 'src/app/services/sesion/sesion.service'; 
import { Usuario } from 'src/app/models/Usuario';

let id_Usuario = 123123131;

@Component({
  selector: 'app-form-user-data',
  templateUrl: './form-user-data.component.html',
  styleUrls: ['./form-user-data.component.css']
})
export class FormUserDataComponent implements OnInit {
  hide1 = true;
  hide2 = true;
  hide3 = true;
  
  formUsuario = new FormGroup({
    rol : new FormControl('',[Validators.required, Validators.nullValidator]),
    nombre : new FormControl('',[Validators.required, Validators.nullValidator]),
    apellidos : new FormControl('',[Validators.required, Validators.nullValidator]),
    rut : new FormControl('',[Validators.required, Validators.nullValidator]),
    correo : new FormControl('',[Validators.required, Validators.nullValidator]),
    //contraseña : new FormControl('',[Validators.required, Validators.nullValidator]),
    nuevaContraseña1 : new FormControl('',[Validators.required, Validators.nullValidator]),
    nuevaContraseña2 : new FormControl('',[Validators.required, Validators.nullValidator])
  });
  formTerapias = new FormArray([new FormControl('')]);
  public usuario:Usuario;
  loadingUsuario:Boolean;

  terapiasImpartidas:Terapia[];
  terapiasFaltantes:Terapia[];
  mayor = 1
  constructor(private service:SesionService){
    this.terapiasImpartidas = [];
    this.terapiasFaltantes = [];
    this.usuario = new Usuario();
    this.loadingUsuario = true;

    
  }

  ngOnInit(): void {
    


    this.service.getUsuario(id_Usuario).subscribe(data => {
      this.formUsuario.setValue({
        rol : `${1}`,
        nombre : `${data.nombre}`,
        apellidos : `${data.apellidos}`,
        rut : `${data.id}`,
        correo : `${data.correo}`,
        //contraseña : "",
        nuevaContraseña1 : "",
        nuevaContraseña2 : "",
      });

      //cambiar id_Usuario con el usuario actual... 
      this.service.getTerapiasDelUsuario(id_Usuario).subscribe(dataT => {
        this.terapiasImpartidas=dataT;       
      });

      //terapiasImpartidas faltantes
      this.service.getTerapiasFaltantes(id_Usuario).subscribe(data => {
        this.terapiasFaltantes=data;
        for (let i = 1; i < data.length; i++) {
          this.formTerapias.insert(i,new FormControl(''));    
        }

      })



      

    });



  };



  cambiarPass(){
    let usuario = new Usuario();
    usuario.id = Number.parseInt(`${this.formUsuario.value.rut}`);
    usuario.password = `${this.formUsuario.value.nuevaContraseña1}`;

    //caso contraseñas vacias: no se puede actualizar
    if(this.formUsuario.value.nuevaContraseña1 == "" || this.formUsuario.value.nuevaContraseña2 == ""){
      window.alert("Debe ingresar una contraseña");
    }
    //caso contraseñas iguales: esta a un paso de actualizar. 
    else if (this.formUsuario.value.nuevaContraseña1 == this.formUsuario.value.nuevaContraseña2){
      this.service.putUsuarioPassword(usuario, usuario.id).subscribe()
      window.alert("Contraseña actualizada con éxito");
      
    }
    //caso contraseñas diferentes: no se puede actualizar la contraseña
    else{
      window.alert("Contraseñas diferentes, intente nuevamente");
    }
    
  }

  onSubmit(){
    let terapiasAgregar:Terapia[];
    terapiasAgregar =[];
    this.terapiasFaltantes.forEach((e,i)=>{
      if(this.formTerapias.value[i] != ''){
        terapiasAgregar.push(e);
      }
    });

    let usuario = new Usuario();
    usuario.id = Number.parseInt(`${this.formUsuario.value.rut}`);
    usuario.nombre =`${this.formUsuario.value.nombre}`;
    usuario.apellidos = `${this.formUsuario.value.apellidos}`;
    usuario.correo = `${this.formUsuario.value.correo}`;
    usuario.terapias = terapiasAgregar;

    this.service.putUsuario(usuario, usuario.id).subscribe()
    window.alert("Informacion actualizada correctamente");
  }
    
}


