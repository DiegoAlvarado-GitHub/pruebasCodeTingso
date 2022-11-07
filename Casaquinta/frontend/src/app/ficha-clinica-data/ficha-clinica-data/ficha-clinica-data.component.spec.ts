import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FichaClinicaDataComponent } from './ficha-clinica-data.component';

describe('FichaClinicaDataComponent', () => {
  let component: FichaClinicaDataComponent;
  let fixture: ComponentFixture<FichaClinicaDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FichaClinicaDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FichaClinicaDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
