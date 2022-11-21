package com.atos.impacta.repositories;

import com.atos.impacta.model.Dependente;

import java.util.List;

public interface DependenteInterface {
    public boolean salvar(Dependente item);
    public List<Dependente> listar();

}
