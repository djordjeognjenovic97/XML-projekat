export class Zahtev{
    id:string;
    mesto:string;
    datum:string;
    nazivOrgana:string;
    constructor(id:string,mesto:string,datum:string,nazivOrgana:string){
        this.id=id;
        this.mesto=mesto;
        this.nazivOrgana=nazivOrgana;
        this.datum=datum;
    }
}