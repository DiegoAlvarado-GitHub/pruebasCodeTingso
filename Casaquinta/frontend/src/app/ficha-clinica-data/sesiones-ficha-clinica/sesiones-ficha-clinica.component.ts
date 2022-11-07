import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { Sesion } from 'src/app/models/Sesion';
import { SesionService } from 'src/app/services/sesion/sesion.service';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort, Sort} from '@angular/material/sort';
import { Router } from '@angular/router';






@Component({
  selector: 'app-sesiones-ficha-clinica',
  templateUrl: './sesiones-ficha-clinica.component.html',
  styleUrls: ['./sesiones-ficha-clinica.component.css']
})

export class SesionesFichaClinicaComponent implements OnInit {
  displayedColumns: string[] = ['fecha', 'tipo_sesion','profesional','formato_presencial', 'privada'];
  loading:Boolean;
  noCoincidencias: Boolean;
  //f, especialidad (terapia recivida), p, tipo (presencial o online), estado (libre o bloqueada)
  @Input() id_ficha: any;
  sesiones:Sesion [];
  dataSource: any;
  @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort!: MatSort;
  clickedRows = new Set<Sesion>();



  
  constructor(private service:SesionService, private router: Router) { 
    this.sesiones = [];
    this.loading = true;
    this.noCoincidencias = true;
  }  



  ngOnInit() {
    this.service.getSesionesFicha(this.id_ficha).subscribe(data => {
      this.sesiones = data.map(e => {
        e.formato_presencial = e.formato_presencial?e.formato_presencial = "Presencial":e.formato_presencial = "Online";
        // e.privada = e.privada?e.privada = "Privada":e.privada = "Abierta";
        return e;
      });

      //se revisa si existen sesiones
      this.noCoincidencias = this.sesiones.length == 0;
      this.loading = false;
      if(!this.noCoincidencias){
        this.dataSource = new MatTableDataSource<Sesion>(this.sesiones);
         this.dataSource.paginator = this.paginator;
         this.dataSource.sort = this.sort; 
      }  


    });
  }

  filtrar(event: Event) {
    const filtro = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filtro.trim().toLowerCase();
  }

  goToSesion(id:number){
    //id tiene la id de la sesion
    this.router.navigateByUrl(`/sesion/${id}`);
  }

  registrarSesion(){
    this.router.navigateByUrl(`/nuevasesion/${this.id_ficha}`);
  }


}

