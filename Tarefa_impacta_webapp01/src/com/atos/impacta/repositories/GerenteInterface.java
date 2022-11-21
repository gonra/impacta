package com.atos.impacta.repositories;

import com.atos.impacta.model.Gerente;

import java.util.List;

public interface GerenteInterface {
    public boolean salvarGerente(Gerente gerente);
    public List<Gerente> listarGerentes();
    public boolean deletarGerenteByCpf(String id);
    public Gerente listarGerenteByCpf(String id);
}