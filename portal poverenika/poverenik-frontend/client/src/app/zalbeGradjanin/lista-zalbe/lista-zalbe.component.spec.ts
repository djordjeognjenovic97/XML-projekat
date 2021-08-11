import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaZalbeComponent } from './lista-zalbe.component';

describe('ListaZalbeComponent', () => {
  let component: ListaZalbeComponent;
  let fixture: ComponentFixture<ListaZalbeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaZalbeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaZalbeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
