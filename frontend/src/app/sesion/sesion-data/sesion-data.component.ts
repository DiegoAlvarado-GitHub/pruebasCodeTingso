import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { SesionService } from 'src/app/services/sesion/sesion.service';
import { Sesion } from 'src/app/models/Sesion';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-sesion-data',
  templateUrl: './sesion-data.component.html',
  styleUrls: ['./sesion-data.component.css']
})
export class SesionDataComponent implements OnInit {
  public datosSesion:Sesion;
  id:Number;

  constructor(private route: ActivatedRoute,  private router: Router, private servicio: SesionService) { 
    this.id = 0;
    this.datosSesion = new Sesion();
  }


  ngOnInit(): void {
    this.id = Number.parseInt(`${this.route.snapshot.paramMap.get('id')}`);
    this.servicio.getSesion(this.id).subscribe(data =>{
      this.datosSesion = data;
      if (this.datosSesion.formato_presencial){
        this.datosSesion.formato_presencial = "Presencial";
      }
      else{
        this.datosSesion.formato_presencial = "Online";
      }

      if (this.datosSesion.acompanado){
        this.datosSesion.acompanado = "Acompañado";
      }
      else{
        this.datosSesion.acompanado = "Solo";
      }



    });

    

  }

  compartirSesion(){
    this.servicio.getEmailOfSesionById(this.id).subscribe();    
    window.alert("Sesión enviada exitosamente");
  }

  volverFicha(){
    this.router.navigateByUrl(`/ficha/${this.datosSesion.fichaClinica}`)    
  }

}
