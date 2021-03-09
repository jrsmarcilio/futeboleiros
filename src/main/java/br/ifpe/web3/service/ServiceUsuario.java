package br.ifpe.web3.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web3.Exceptions.ErrCripto;
import br.ifpe.web3.Exceptions.UsernameExists;
import br.ifpe.web3.dados.UsuarioDAO;
import br.ifpe.web3.model.Usuario;
import br.ifpe.web3.util.Util;

@Service
public class ServiceUsuario {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public void salvarUsuario(Usuario user) throws Exception {

		try {
			if (usuarioDAO.findByUsername(user.getUsername()) != null) {
				throw new UsernameExists("Já existe um email cadastrado para: " + user.getUsername());
			}
			user.setSenha(Util.md5(user.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			throw new ErrCripto("Erro na criptografia da senha.");
		}
		usuarioDAO.save(user);
	}


	public Usuario loginUser(String username, String senha) throws ServicesExceptions {
		Usuario Login = usuarioDAO.findByLogin(username, senha);
		return Login;
	}
}