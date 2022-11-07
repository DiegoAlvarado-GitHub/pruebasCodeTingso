import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaFichaClinicaComponent } from './tabla-ficha-clinica.component';

describe('TablaFichaClinicaComponent', () => {
  let component: TablaFichaClinicaComponent;
  let fixture: ComponentFixture<TablaFichaClinicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TablaFichaClinicaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TablaFichaClinicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
