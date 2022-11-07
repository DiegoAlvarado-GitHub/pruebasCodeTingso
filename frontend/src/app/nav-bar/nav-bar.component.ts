import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  value = '';
  tipoDato = new FormControl('nombre');
  busqueda = new FormControl('');
  

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  //para redireccionar a la ventana que contiene la tabla con la informacion solicitada, entregando como parametro lo ingresado
  busquedaPaciente(){
    //this.router.navigateByUrl(`/paciente/${this.busqueda.value}/type/${this.tipoDato.value}`);
    // this.router.navigateByUrl(`/`, {skipLocationChange: true}).then(() => this.router.navigateByUrl(`/paciente/${this.busqueda.value}/type/${this.tipoDato.value}`));
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.navigateByUrl(`/paciente/${this.busqueda.value}/type/${this.tipoDato.value}`);

    
  }

}
