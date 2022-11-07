import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormSesionComponent } from './form-sesion/form-sesion.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { RootComponent } from './root/root.component';
import { NuevaFichaComponent } from './nueva-ficha/nueva-ficha.component';
import { ContenedorUserComponent } from './user-register/contenedor-user/contenedor-user.component';
import { ContenedorUserDataComponent } from './user-data/contenedor-user-data/contenedor-user-data.component';
import { SesionContenedorComponent } from './sesion/sesion-contenedor/sesion-contenedor.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ContenedorSearchFichaClinicaComponent } from './ficha-clinica-search/contenedor-search-ficha-clinica/contenedor-search-ficha-clinica.component';
import { AnamnesisComponent } from './anamnesis/anamnesis.component';
import { FichaClinicaContenedorComponent } from './ficha-clinica-data/ficha-clinica-contenedor/ficha-clinica-contenedor.component';
const routes: Routes = [
  
  { path: '', component: NavBarComponent, children: [
    { path: 'nuevasesion/:id_ficha', component: FormSesionComponent, pathMatch: 'full'},
    { path: 'nuevaficha', component: NuevaFichaComponent, pathMatch: 'full'},
    { path: 'nuevousuario', component: ContenedorUserComponent, pathMatch: 'full'},
    { path: 'usuario', component: ContenedorUserDataComponent, pathMatch: 'full'},
    { path: 'sesion/:id', component: SesionContenedorComponent, pathMatch: 'full'},
    { path: 'paciente/:busqueda/type/:tipo', component: ContenedorSearchFichaClinicaComponent, pathMatch: 'full'},
    { path: 'anamnesis', component: AnamnesisComponent, pathMatch: 'full'},
    { path: 'ficha/:id', component: FichaClinicaContenedorComponent, pathMatch: 'full'},
  ]},
  { path: 'root',redirectTo:'', component: RootComponent, pathMatch: 'full'},
  { path: '**', component: NotFoundComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{
    onSameUrlNavigation : 'reload'

  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
