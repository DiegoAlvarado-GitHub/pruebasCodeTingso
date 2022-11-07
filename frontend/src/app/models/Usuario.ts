import { Terapia } from "./Terapia";

export class Usuario {
    "id": Number;
    "nombre": String;
    "apellidos": String;
    "correo": String;
    "especialidad": String;
    "password": String;
    "terapias":Array<Terapia>;

    constructor(){
        this.id = 0;
        this.nombre = "";
        this.apellidos = "";
        this.correo = "";
        this.especialidad = "";
        this.password = "";
        this.terapias = [];
    }
};