import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCuidadorComponent } from './add-cuidador.component';

describe('AddCuidadorComponent', () => {
  let component: AddCuidadorComponent;
  let fixture: ComponentFixture<AddCuidadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCuidadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCuidadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
