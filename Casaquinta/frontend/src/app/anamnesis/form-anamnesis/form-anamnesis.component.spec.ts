import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAnamnesisComponent } from './form-anamnesis.component';

describe('FormAnamesisComponent', () => {
  let component: FormAnamnesisComponent;
  let fixture: ComponentFixture<FormAnamnesisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAnamnesisComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormAnamnesisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});