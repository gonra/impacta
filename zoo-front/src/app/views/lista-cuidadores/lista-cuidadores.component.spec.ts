import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCuidadoresComponent } from './lista-cuidadores.component';

describe('ListaCuidadoresComponent', () => {
  let component: ListaCuidadoresComponent;
  let fixture: ComponentFixture<ListaCuidadoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaCuidadoresComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaCuidadoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
