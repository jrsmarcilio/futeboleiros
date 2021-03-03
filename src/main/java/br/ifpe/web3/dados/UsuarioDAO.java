package br.ifpe.web3.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web3.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

	public Usuario findByLoginAndSenha(String login, String senha);
}
