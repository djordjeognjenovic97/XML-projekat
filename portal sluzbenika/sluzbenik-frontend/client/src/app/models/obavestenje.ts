export class Obavestenje{
    id:string;
    datum:string;
    nazivOrgana:string;
    constructor(id:string,datum:string,nazivOrgana:string){
        this.id=id;
        this.nazivOrgana=nazivOrgana;
        this.datum=datum;
    }
}