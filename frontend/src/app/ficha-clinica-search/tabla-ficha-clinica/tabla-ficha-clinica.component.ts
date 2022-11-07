import { Component, OnInit , ViewChild} from '@angular/core';
import { ActivatedRoute  } from '@angular/router';
import { Ficha_clinica } from 'src/app/models/Ficha_clinica';
import { SesionService } from 'src/app/services/sesion/sesion.service';
import { MatTableDataSource } from '@angular/material/table';
import {MatSort, Sort} from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';


@Component({
  selector: 'app-tabla-ficha-clinica',
  templateUrl: './tabla-ficha-clinica.component.html',
  styleUrls: ['./tabla-ficha-clinica.component.css']
})
export class TablaFichaClinicaComponent implements OnInit {
  buscar:String;
  loading:Boolean;
  noCoincidencias: Boolean;
  displayedColumns: string[] = ['rut', 'nombre', 'nivel_escolaridad', 'terapias_recibidas', 'fecha_ingreso'];
  fichas: Ficha_clinica[];
  dataSource: any;
  @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort!: MatSort;
  clickedRows = new Set<Ficha_clinica>();

  constructor(private route: ActivatedRoute , private servicio: SesionService, private router: Router) {
    this.buscar = '';
    this.loading = true;
    this.noCoincidencias = true;
    this.fichas= [];
    this.dataSource = new MatTableDataSource<Ficha_clinica>(this.fichas);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
   }

  ngOnInit(){
    this.buscar = `${this.route.snapshot.paramMap.get('busqueda')}`;
    let tipo = this.route.snapshot.paramMap.get('tipo');
    if(tipo == 'nombre'){
      this.servicio.getFichasByName(this.buscar).subscribe(data =>{
        this.fichas = data;
        //se revisa si existen fichas clinicas
        this.noCoincidencias = this.fichas.length == 0;
        this.loading = false;
        if(!this.noCoincidencias){
          this.dataSource = new MatTableDataSource<Ficha_clinica>(this.fichas);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;  
        }   
     });
    }else if(tipo == 'rut'){
      // si no encuentra el rut da error...
      this.servicio.getFichaExiste(Number.parseInt(`${this.buscar}`)).subscribe(data =>{
        //caso no hay ninguna ficha clinica
        if(data == true){
          this.servicio.getFichaById(Number.parseInt(`${this.buscar}`)).subscribe(data =>{
            this.fichas.push(data);
            this.noCoincidencias = this.fichas.length == 0;
            this.loading = false;
            //Si hay coincidencias, se redirige directamente a la ficha clinica, caso contrario, muestra la tabla vacia y aparece boton para crear paciente
            if(!this.noCoincidencias){
              this.router.navigateByUrl(`/ficha/${Number.parseInt(`${this.buscar}`)}`)    
            }   
          }); 
        }
        //caso si hay ficha clinica
        else{
          this.loading = false;  
          this.dataSource = new MatTableDataSource<Ficha_clinica>(this.fichas);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        }
      });
                    
      }
    else{
      this.router.navigateByUrl(`/notFound`);
    }

  }

  filtrar(event: Event) {
    const filtro = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filtro.trim().toLowerCase();
  }

  goToFicha(id:number){
    //id tiene la id de la sesion
    this.router.navigateByUrl(`/ficha/${id}`);
  }

  registarPaciente(){
    this.router.navigateByUrl(`/nuevaficha`);
  }

}
