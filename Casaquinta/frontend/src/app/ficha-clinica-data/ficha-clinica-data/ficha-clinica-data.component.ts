import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Ficha_clinica } from 'src/app/models/Ficha_clinica';
import { SesionService } from 'src/app/services/sesion/sesion.service';
import { Sesion } from 'src/app/models/Sesion';
@Component({
  selector: 'app-ficha-clinica-data',
  templateUrl: './ficha-clinica-data.component.html',
  styleUrls: ['./ficha-clinica-data.component.css']
})
export class FichaClinicaDataComponent implements OnInit {
  id:Number;
  ficha:Ficha_clinica;

  constructor(private route: ActivatedRoute, private servicio: SesionService) { 
    this.id = 0;
    this.ficha = new Ficha_clinica();

    
  }

  ngOnInit(): void {

    this.id = Number.parseInt(`${this.route.snapshot.paramMap.get('id')}`); 
    this.servicio.getFichaById(this.id).subscribe(data=>{ 
      this.ficha = data;
    });
  }

}
