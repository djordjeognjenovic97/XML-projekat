import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaObavestenjaComponent } from './lista-obavestenja.component';

describe('ListaObavestenjaComponent', () => {
  let component: ListaObavestenjaComponent;
  let fixture: ComponentFixture<ListaObavestenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaObavestenjaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaObavestenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
