import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaResenjaPoverenikComponent } from './lista-resenja-poverenik.component';

describe('ListaResenjaPoverenikComponent', () => {
  let component: ListaResenjaPoverenikComponent;
  let fixture: ComponentFixture<ListaResenjaPoverenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaResenjaPoverenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaResenjaPoverenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
