import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TemplejtComponent } from './templejt.component';

describe('TemplejtComponent', () => {
  let component: TemplejtComponent;
  let fixture: ComponentFixture<TemplejtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TemplejtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TemplejtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
