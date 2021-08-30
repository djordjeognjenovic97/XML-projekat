import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaZalbaCutanjeComponent } from './lista-zalba-cutanje.component';

describe('ListaZalbaCutanjeComponent', () => {
  let component: ListaZalbaCutanjeComponent;
  let fixture: ComponentFixture<ListaZalbaCutanjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaZalbaCutanjeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaZalbaCutanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
