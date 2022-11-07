import { Terapia } from "./Terapia";

export class Ficha_clinica {
    "rut": Number;
    "nombre": String;
    "apellido":String;
    "fecha_nacimiento":String;
    "fecha_ingreso":String;
    "nivel_escolaridad":String;
    "terapias_recibidas":String;
    "terapias":Terapia[];
    "direccion":String;
    "comuna":String;
    "telefono":String;
    "correo":String;
    "tutor":String;
    "parentesco":String;
    

    constructor(){
        this.rut = 0;
        this.nombre = "";
        this.apellido = "";
        this.fecha_ingreso = "";
        this.fecha_nacimiento = "";
        this.nivel_escolaridad = "";
        this.terapias_recibidas = "";
        this.terapias = [];
        this.direccion = "";
        this.comuna = "";
        this.telefono = "";
        this.correo = "";
        this.tutor = "";
        this.parentesco = "";
    }
};