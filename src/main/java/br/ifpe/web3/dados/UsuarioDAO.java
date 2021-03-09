package br.ifpe.web3.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web3.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

	public Usuario findByUsernameAndSenha(String username, String senha);
	
	@Query(value = "SELECT * from usuario where username = :username", nativeQuery = true)
	public Usuario findByUsername(String username);
	
	@Query(value = "SELECT * from usuario where username = :username and senha = :senha", nativeQuery = true)
	public Usuario findByLogin(String username, String senha);
}
