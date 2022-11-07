import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FichaClinicaContenedorComponent } from './ficha-clinica-contenedor.component';

describe('FichaClinicaContenedorComponent', () => {
  let component: FichaClinicaContenedorComponent;
  let fixture: ComponentFixture<FichaClinicaContenedorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FichaClinicaContenedorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FichaClinicaContenedorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
