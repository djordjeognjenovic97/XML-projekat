import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaZahtevComponent } from './lista-zahtev.component';

describe('ListaZahtevComponent', () => {
  let component: ListaZahtevComponent;
  let fixture: ComponentFixture<ListaZahtevComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaZahtevComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaZahtevComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
