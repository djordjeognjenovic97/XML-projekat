import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaZalbaOdbijenComponent } from './lista-zalba-odbijen.component';

describe('ListaZalbaOdbijenComponent', () => {
  let component: ListaZalbaOdbijenComponent;
  let fixture: ComponentFixture<ListaZalbaOdbijenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaZalbaOdbijenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaZalbaOdbijenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
