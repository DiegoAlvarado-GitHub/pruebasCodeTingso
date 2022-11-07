import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SesionContenedorComponent } from './sesion-contenedor.component';

describe('SesionContenedorComponent', () => {
  let component: SesionContenedorComponent;
  let fixture: ComponentFixture<SesionContenedorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SesionContenedorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SesionContenedorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
