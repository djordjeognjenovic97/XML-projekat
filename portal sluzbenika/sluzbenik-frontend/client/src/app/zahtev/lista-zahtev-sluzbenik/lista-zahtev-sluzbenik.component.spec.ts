import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaZahtevSluzbenikComponent } from './lista-zahtev-sluzbenik.component';

describe('ListaZahtevSluzbenikComponent', () => {
  let component: ListaZahtevSluzbenikComponent;
  let fixture: ComponentFixture<ListaZahtevSluzbenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaZahtevSluzbenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaZahtevSluzbenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
