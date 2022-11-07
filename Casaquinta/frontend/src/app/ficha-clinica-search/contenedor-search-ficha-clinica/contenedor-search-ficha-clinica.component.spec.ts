import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContenedorSearchFichaClinicaComponent } from './contenedor-search-ficha-clinica.component';

describe('ContenedorSearchFichaClinicaComponent', () => {
  let component: ContenedorSearchFichaClinicaComponent;
  let fixture: ComponentFixture<ContenedorSearchFichaClinicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContenedorSearchFichaClinicaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContenedorSearchFichaClinicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
