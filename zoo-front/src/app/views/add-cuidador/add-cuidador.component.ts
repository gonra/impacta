import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { CuidadoresService } from 'src/app/services/cuidadores.service';
import { Cuidadores } from '../../model/cuidadores';

@Component({
  selector: 'app-add-cuidador',
  templateUrl: './add-cuidador.component.html',
  styleUrls: ['./add-cuidador.component.css']
})
export class AddCuidadorComponent implements OnInit {

  cuidadorForm : any;
  mensagem: any = null;
  constructor(private cuidadoresService : CuidadoresService, 
              private router: Router) {    
    this.cuidadorForm = new FormGroup({
      nome: new FormControl(''),
      idade : new FormControl(''),
      profissao : new FormControl('')
    }); 
  }

  ngOnInit(): void {
  }

  salvar(): void {
    const dataForm = this.cuidadorForm.value;
    const cuidador: Cuidadores = {
      nome: dataForm.nome,
      idade: dataForm.idade,
      profissao: dataForm.profissao
    }
    this.cuidadoresService.saveElemento(cuidador).subscribe(()=>{
      this.mensagem = "Pessoa salva!";
      this.cuidadoresService.setEtapa(1);
    });

    
  }

}
