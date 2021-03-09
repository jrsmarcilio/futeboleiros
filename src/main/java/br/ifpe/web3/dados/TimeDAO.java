package br.ifpe.web3.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ifpe.web3.model.Tecnico;
import br.ifpe.web3.model.Time;

public interface TimeDAO extends JpaRepository<Time, Integer>{

	/* PESQUISA DE TIME PELO NOME APROXIMADO*/
	@Query(value="SELECT * FROM time j WHERE j.nome LIKE %:nome%", nativeQuery=true)
	List<Time> findByNamedQuery(@Param("nome") String nome);
	
	/* PESQUISA DE TIME PELO ID*/
	@Query(value="SELECT * FROM time j WHERE j.time_id = :id", nativeQuery=true)
	List<Time> findByClubQuery(@Param("id") Integer id);

	
}
