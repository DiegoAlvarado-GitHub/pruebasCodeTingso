import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SesionDataComponent } from './sesion-data.component';

describe('SesionDataComponent', () => {
  let component: SesionDataComponent;
  let fixture: ComponentFixture<SesionDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SesionDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SesionDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
