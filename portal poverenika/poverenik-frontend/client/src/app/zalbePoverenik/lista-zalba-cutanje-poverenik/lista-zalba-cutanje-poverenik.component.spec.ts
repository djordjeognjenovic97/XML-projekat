import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaZalbaCutanjePoverenikComponent } from './lista-zalba-cutanje-poverenik.component';

describe('ListaZalbaCutanjePoverenikComponent', () => {
  let component: ListaZalbaCutanjePoverenikComponent;
  let fixture: ComponentFixture<ListaZalbaCutanjePoverenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaZalbaCutanjePoverenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaZalbaCutanjePoverenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
