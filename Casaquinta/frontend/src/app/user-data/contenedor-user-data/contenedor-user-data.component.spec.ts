import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContenedorUserDataComponent } from './contenedor-user-data.component';

describe('ContenedorUserDataComponent', () => {
  let component: ContenedorUserDataComponent;
  let fixture: ComponentFixture<ContenedorUserDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContenedorUserDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContenedorUserDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
