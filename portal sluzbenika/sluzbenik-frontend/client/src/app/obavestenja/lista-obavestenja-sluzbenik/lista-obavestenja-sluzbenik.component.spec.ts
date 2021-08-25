import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaObavestenjaSluzbenikComponent } from './lista-obavestenja-sluzbenik.component';

describe('ListaObavestenjaSluzbenikComponent', () => {
  let component: ListaObavestenjaSluzbenikComponent;
  let fixture: ComponentFixture<ListaObavestenjaSluzbenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaObavestenjaSluzbenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaObavestenjaSluzbenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
