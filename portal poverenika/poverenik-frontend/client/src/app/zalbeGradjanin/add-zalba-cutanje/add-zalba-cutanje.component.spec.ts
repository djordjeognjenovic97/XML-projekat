import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddZalbaCutanjeComponent } from './add-zalba-cutanje.component';

describe('AddZalbaCutanjeComponent', () => {
  let component: AddZalbaCutanjeComponent;
  let fixture: ComponentFixture<AddZalbaCutanjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddZalbaCutanjeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddZalbaCutanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
