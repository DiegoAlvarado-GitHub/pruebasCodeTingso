import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContenedorUserComponent } from './contenedor-user.component';

describe('ContenedorUserComponent', () => {
  let component: ContenedorUserComponent;
  let fixture: ComponentFixture<ContenedorUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContenedorUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContenedorUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
