import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaResenjaSluzbenikComponent } from './lista-resenja-sluzbenik.component';

describe('ListaResenjaSluzbenikComponent', () => {
  let component: ListaResenjaSluzbenikComponent;
  let fixture: ComponentFixture<ListaResenjaSluzbenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaResenjaSluzbenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaResenjaSluzbenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
