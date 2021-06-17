import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddZahtevComponent } from './add-zahtev.component';

describe('AddZahtevComponent', () => {
  let component: AddZahtevComponent;
  let fixture: ComponentFixture<AddZahtevComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddZahtevComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddZahtevComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
