import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzjasnjenjeComponent } from './izjasnjenje.component';

describe('IzjasnjenjeComponent', () => {
  let component: IzjasnjenjeComponent;
  let fixture: ComponentFixture<IzjasnjenjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzjasnjenjeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IzjasnjenjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
