package br.ifpe.web3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web3.dados.UsuarioDAO;
import br.ifpe.web3.model.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping("cadastrar_usuario")
	public String cadastrarUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usuario";
	}
	
	@PostMapping("/salvar_usuario")
	public String salvarUsuario(Usuario usuario) {
		this.usuarioDAO.save(usuario);
		return "login";
	}
	
	@GetMapping("/edit_usuario")
	public String editarUsuario(Model model, Integer id) {
		Usuario usuario = this.usuarioDAO.getOne(id);
		model.addAttribute("usuario", usuario);

		return "home";
	}

	@GetMapping("/home")
	public String exibirHome() {
		return "home";
	}
}
