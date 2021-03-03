package br.ifpe.web3.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web3.model.Tecnico;

public interface TecnicoDAO extends JpaRepository<Tecnico, Integer>{

}
