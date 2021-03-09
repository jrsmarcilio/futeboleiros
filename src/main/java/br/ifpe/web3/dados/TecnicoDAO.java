package br.ifpe.web3.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ifpe.web3.model.Tecnico;

public interface TecnicoDAO extends JpaRepository<Tecnico, Integer>{

	/* PESQUISA DE JOGADOR PELO NOME APROXIMADO*/
	@Query(value="SELECT * FROM tecnico j WHERE j.nome LIKE %:nome%", nativeQuery=true)
	List<Tecnico> findByNamedQuery(@Param("nome") String nome);
	
	/* PESQUISA DE TIME PELO ID*/
	@Query(value="SELECT * FROM tecnico j WHERE j.time_id = :id", nativeQuery=true)
	List<Tecnico> findByClubQuery(@Param("id") Integer id);

	
}
