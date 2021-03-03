package br.ifpe.web3.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ifpe.web3.model.Time;

public interface TimeDAO extends JpaRepository<Time, Integer>{

	/* PESQUISA DE TIME PELO NOME*/
	@Query(value="SELECT * FROM time t WHERE t.nome = :nome", nativeQuery=true)
	Time findByClubQuery(@Param("nome") String nome);
	
}
