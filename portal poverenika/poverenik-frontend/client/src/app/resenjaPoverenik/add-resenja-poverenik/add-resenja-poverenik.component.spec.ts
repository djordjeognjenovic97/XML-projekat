import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddResenjaPoverenikComponent } from './add-resenja-poverenik.component';

describe('AddResenjaPoverenikComponent', () => {
  let component: AddResenjaPoverenikComponent;
  let fixture: ComponentFixture<AddResenjaPoverenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddResenjaPoverenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddResenjaPoverenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
