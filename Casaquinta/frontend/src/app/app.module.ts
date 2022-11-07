//Componentes basicos de angular
import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule  } from '@angular/forms'; 
//Mis componentes
import { FormUserComponent } from './user-register/form-user/form-user.component'
import { FormSesionComponent } from './form-sesion/form-sesion.component';
import { RootComponent } from './root/root.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { FormComponent } from './form-sesion/form/form.component';
import { NuevaFichaComponent } from './nueva-ficha/nueva-ficha.component';
import { FormFichaComponent } from './nueva-ficha/form-ficha/form-ficha.component';
//Importaciones
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatMomentDateModule, MAT_MOMENT_DATE_ADAPTER_OPTIONS, MomentDateAdapter} from '@angular/material-moment-adapter';
import { MAT_DATE_LOCALE } from '@angular/material/core';

//Material components
import { MaterialModule } from './material/material.module';



import { registerLocaleData } from '@angular/common';
import localEs from '@angular/common/locales/es';
import { ContenedorUserComponent } from './user-register/contenedor-user/contenedor-user.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ContenedorUserDataComponent } from './user-data/contenedor-user-data/contenedor-user-data.component';
import { FormUserDataComponent } from './user-data/form-user-data/form-user-data.component';
import { SesionesFichaClinicaComponent } from './ficha-clinica-data/sesiones-ficha-clinica/sesiones-ficha-clinica.component';
import { SesionDataComponent } from './sesion/sesion-data/sesion-data.component';
import { SesionContenedorComponent } from './sesion/sesion-contenedor/sesion-contenedor.component';
import { TablaFichaClinicaComponent } from './ficha-clinica-search/tabla-ficha-clinica/tabla-ficha-clinica.component';
import { ContenedorSearchFichaClinicaComponent } from './ficha-clinica-search/contenedor-search-ficha-clinica/contenedor-search-ficha-clinica.component';
import { AnamnesisComponent } from './anamnesis/anamnesis.component';
import { FormAnamnesisComponent} from './anamnesis/form-anamnesis/form-anamnesis.component';
import { FichaClinicaContenedorComponent } from './ficha-clinica-data/ficha-clinica-contenedor/ficha-clinica-contenedor.component';
import { FichaClinicaDataComponent } from './ficha-clinica-data/ficha-clinica-data/ficha-clinica-data.component';
registerLocaleData(localEs, 'es');


@NgModule({
  declarations: [
    AppComponent,
    FormSesionComponent,
    RootComponent,
    NotFoundComponent,
    FormComponent,
    NuevaFichaComponent,
    FormFichaComponent,
    FormUserComponent,
    ContenedorUserComponent,
    NavBarComponent,
    ContenedorUserDataComponent,
    FormUserDataComponent,
    SesionesFichaClinicaComponent,
    SesionDataComponent,
    SesionContenedorComponent,
    TablaFichaClinicaComponent,
    ContenedorSearchFichaClinicaComponent,
    AnamnesisComponent,
    FormAnamnesisComponent,
    FichaClinicaContenedorComponent,
    FichaClinicaDataComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    MatMomentDateModule,
    ReactiveFormsModule,
    FormsModule 
    
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'es'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
