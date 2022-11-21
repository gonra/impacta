package com.atos.impacta.repositories;

import com.atos.impacta.model.Dependente;
import com.atos.impacta.persistence.DependenteDAO;

import java.util.List;

public class RepositorioDependente implements DependenteInterface{

    DependenteDAO dependenteDAO;

    public RepositorioDependente() {
        this.dependenteDAO = new DependenteDAO();
    }

    @Override
    public boolean salvar(Dependente item) {
        return dependenteDAO.salvar(item);
    }

    @Override
    public List<Dependente> listar() {
        return dependenteDAO.listar();
    }
}
