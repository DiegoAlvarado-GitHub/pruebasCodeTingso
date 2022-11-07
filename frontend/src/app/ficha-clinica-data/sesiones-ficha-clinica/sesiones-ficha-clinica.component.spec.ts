import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SesionesFichaClinicaComponent } from './sesiones-ficha-clinica.component';

describe('SesionesFichaClinicaComponent', () => {
  let component: SesionesFichaClinicaComponent;
  let fixture: ComponentFixture<SesionesFichaClinicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SesionesFichaClinicaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SesionesFichaClinicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
