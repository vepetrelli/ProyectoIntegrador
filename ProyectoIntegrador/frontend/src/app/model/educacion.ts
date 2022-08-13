export class Educacion {
    id: number;
    nombreE: string;
    descripcionE: string;
    anoE: string;

    constructor(nombreE: string, descripcionE: string, anoE: string){
        this.nombreE = nombreE;
        this.descripcionE= descripcionE;
        this.anoE=anoE;
    }
}
