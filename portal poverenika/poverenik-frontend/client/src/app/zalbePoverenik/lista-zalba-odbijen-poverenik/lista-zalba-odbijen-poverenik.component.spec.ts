import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaZalbaOdbijenPoverenikComponent } from './lista-zalba-odbijen-poverenik.component';

describe('ListaZalbaOdbijenPoverenikComponent', () => {
  let component: ListaZalbaOdbijenPoverenikComponent;
  let fixture: ComponentFixture<ListaZalbaOdbijenPoverenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaZalbaOdbijenPoverenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaZalbaOdbijenPoverenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
