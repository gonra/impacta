package com.atos.impacta.repositories;

import com.atos.impacta.model.Gerente;
import com.atos.impacta.persistence.GerenteDAO;

import java.util.List;
import java.util.ArrayList;

public class RepositorioGerente implements GerenteInterface {

    private List<Gerente> listaGerentes = new ArrayList<>();

    private GerenteDAO gerenteDAO;

    public RepositorioGerente() {
        this.gerenteDAO = new GerenteDAO();
    }


    public boolean salvarGerente(Gerente gerente){
        String cpf = gerente.getCpf();
        Gerente aux = listarGerenteByCpf(cpf);
        if(aux != null){
            deletarGerenteByCpf(cpf);
        }
        this.listaGerentes.add(gerente);

        return true;
    }

    public boolean salvarGerenteDB(Gerente gerente){
        return gerenteDAO.salvarGerente(gerente);
    }

    public List<Gerente> listarGerentes() {
        return this.listaGerentes;
    }

    public List<Gerente> listarDB(){
        return gerenteDAO.listar();
    }

    public boolean deletarGerenteByCpf(String cpf){
        Gerente gerenteToDelete = null;
        for(Gerente item: this.listaGerentes){
            if(item.getCpf().equals(cpf)){
                gerenteToDelete = item;
                break;
            }
        }
        if (gerenteToDelete == null){
            return false;
        }
        try {
            this.listaGerentes.remove(gerenteToDelete);
            return true;
        } catch (Exception e){
            System.out.println("Erro");
            return false;
        }
    }

    public boolean deletarGerenteByCpfDb(String cpf) {
        gerenteDAO.deletarGerente(cpf);
        return true;
    }

    public Gerente listarGerenteByCpf(String cpf){
        for(Gerente item: this.listaGerentes){
            if(item.getCpf().equals(cpf)){
                return(item);
            }
        }
        return null;
    }

    public Gerente listarGerenteByCpfDb(String cpf) {
        return gerenteDAO.listarByCpf(cpf);
    }
}