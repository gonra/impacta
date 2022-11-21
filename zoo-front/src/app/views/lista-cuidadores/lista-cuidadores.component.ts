import { Component, OnInit } from '@angular/core';
import { CuidadoresService } from 'src/app/services/cuidadores.service';
import { Cuidadores } from 'src/app/model/cuidadores';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-lista-cuidadores',
  templateUrl: './lista-cuidadores.component.html',
  styleUrls: ['./lista-cuidadores.component.css']
})
export class ListaCuidadoresComponent implements OnInit {
  
  displayedColumns: string[] = ['nome', 'profissao', 'idade','editar-deletar'];
  listaElementos:  Observable<Cuidadores []> ;
  enTela: Number = 0;
  id: Number = -1;

  constructor(private cuidadoresService:CuidadoresService) { 
    this.listaElementos = cuidadoresService.listaElementos();
  }

  ngOnInit(): void {
  }

  openEdit(id:Number){
    this.enTela = 1;
    this.id = id;
    console.log('Recibi edit '+id);
  }

  openDelete(id: Number){
    this.enTela = 2;
    this.id = id;
  }

  deletar(){
    this.cuidadoresService.deleteElemento(this.id).subscribe(()=>{
      //this.mensagem = "Pessoa deletada!";
      this.enTela = 0;
    });
  }

  cancelar(){
    this.enTela = 0;
  }
}
