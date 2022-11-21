package com.atos.impacta.repositories;

import com.atos.impacta.model.Coordenador;

import java.util.List;

public interface CoordenadorInterface {
    public boolean salvarCoordenador(Coordenador item);
    public List<Coordenador> listarCoordenador();
    public boolean deletarCoordenadorByCpf(String id);
    public Coordenador listarCoordenadorByCpf(String id);
}
