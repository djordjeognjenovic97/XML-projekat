import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaIzvestajaPoverenikComponent } from './lista-izvestaja-poverenik.component';

describe('ListaIzvestajaPoverenikComponent', () => {
  let component: ListaIzvestajaPoverenikComponent;
  let fixture: ComponentFixture<ListaIzvestajaPoverenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaIzvestajaPoverenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaIzvestajaPoverenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
