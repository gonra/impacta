import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCuidadorComponent } from './edit-cuidador.component';

describe('EditCuidadorComponent', () => {
  let component: EditCuidadorComponent;
  let fixture: ComponentFixture<EditCuidadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditCuidadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditCuidadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
