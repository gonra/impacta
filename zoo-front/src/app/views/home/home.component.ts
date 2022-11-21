import { Component, OnInit } from '@angular/core';
import { CuidadoresService } from 'src/app/services/cuidadores.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public enTela : Number = 0;
  constructor(public cuidadoresService:CuidadoresService) { }

  toEditor(){
    this.cuidadoresService.setEtapa(2);
  }

  toList(){
    this.cuidadoresService.setEtapa(1);
  }

  ngOnInit(): void {
  }

}
