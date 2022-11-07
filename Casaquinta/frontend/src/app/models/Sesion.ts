import { Ficha_clinica } from "./Ficha_clinica";

export class Sesion {
    "fecha":  string; 
    "indicacion_cuidadores":String; 
    "objetivo_actividad":String;
    "observaciones":String; 
    "privada":String; 
    "profesional":String; 
    "tipo_sesion":String;
    "formato_presencial":String; 
    "acompanado":String; 
    "fichaClinica": Number | Ficha_clinica;
    constructor(){
        this.fecha = ""; 
        this.indicacion_cuidadores= ""; 
        this.objetivo_actividad= "";
        this.observaciones= ""; 
        this.privada= ""; 
        this.profesional= ""; 
        this.tipo_sesion= "";
        this.formato_presencial= ""; 
        this.acompanado = ""; 
        this.fichaClinica = new Ficha_clinica();
    }
};
  