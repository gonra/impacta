import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cuidadores } from '../model/cuidadores';

@Injectable({
  providedIn: 'root'
})
export class CuidadoresService {

  myhost = "localhost";
  etapa: Number = 1;
  constructor(private httpClient: HttpClient) { }

  listaElementos2(){
    return [
      {id: 1, nome: 'Pedro', idade: 40, profissao: 'Motorista'},
      {id: 2, nome: 'Luis', idade: 50, profissao: 'Gari'},
      {id: 3, nome: 'Maria', idade: 35, profissao: 'Modelo'},
      {id: 4, nome: 'Ana', idade: 42, profissao: 'Medico'}
    ];
  }

  listaElementos(){
    return this.httpClient.get<Cuidadores[]>('http://'+this.myhost+':8080/api/pessoa');
  }

  saveElemento(cuidador:Cuidadores){
    return this.httpClient.post<Cuidadores>('http://'+this.myhost+':8080/api/pessoa',cuidador);
  }

  deleteElemento(id:Number){
    return this.httpClient.delete('http://'+this.myhost+':8080/api/pessoa/'+id);
  }

  setEtapa(id:Number){
    this.etapa = id;
  }

  getEtapa(){
    return this.etapa;
  }

}
