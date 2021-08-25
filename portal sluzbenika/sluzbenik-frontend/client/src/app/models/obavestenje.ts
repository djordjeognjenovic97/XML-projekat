export class Obavestenje{
    id:string;
    mesto:string;
    datum:string;
    nazivOrgana:string;
    stanje:string;
    constructor(id:string,mesto:string,datum:string,nazivOrgana:string,stanje:string){
        this.id=id;
        this.mesto=mesto;
        this.nazivOrgana=nazivOrgana;
        this.datum=datum;
        this.stanje=stanje;
    }
}