import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaResenjaComponent } from './lista-resenja.component';

describe('ListaResenjaComponent', () => {
  let component: ListaResenjaComponent;
  let fixture: ComponentFixture<ListaResenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaResenjaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaResenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
