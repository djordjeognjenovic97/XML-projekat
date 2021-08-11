import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddZalbaOdbijenComponent } from './add-zalba-odbijen.component';

describe('AddZalbaOdbijenComponent', () => {
  let component: AddZalbaOdbijenComponent;
  let fixture: ComponentFixture<AddZalbaOdbijenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddZalbaOdbijenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddZalbaOdbijenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
