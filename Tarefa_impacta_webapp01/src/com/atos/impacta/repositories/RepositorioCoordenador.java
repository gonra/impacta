package com.atos.impacta.repositories;

import com.atos.impacta.model.Coordenador;
import com.atos.impacta.persistence.CoordenadorDAO;

import java.util.List;

public class RepositorioCoordenador implements CoordenadorInterface {

    private final CoordenadorDAO coordenadorDAO = new CoordenadorDAO();

    @Override
    public boolean salvarCoordenador(Coordenador item) {
        return coordenadorDAO.salvar(item);
    }

    @Override
    public List<Coordenador> listarCoordenador() {
        return coordenadorDAO.listar();
    }

    @Override
    public boolean deletarCoordenadorByCpf(String cpf) {
        return coordenadorDAO.deletarByCpf(cpf);
    }

    @Override
    public Coordenador listarCoordenadorByCpf(String cpf) {
        return coordenadorDAO.listarByCpf(cpf);
    }
}
