package br.ifpe.web3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web3.dados.UsuarioDAO;
import br.ifpe.web3.model.Usuario;

@Controller
public class LoginController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@GetMapping("/")
	public String telaInicial(Usuario usuario) {
		return "pagInicial";
	}

	@PostMapping("/efetuar_login")
	public String efetuarLogin(Usuario usuario, RedirectAttributes ra, HttpSession session, Model model) {

		usuario = this.usuarioDAO.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());

		if (usuario != null) {
			session.setAttribute("usuarioLogado", usuario);
			model.addAttribute("nome", usuario.getNome());
			return "redirect:/home";

		} else {
			ra.addFlashAttribute("mensagem", "Login ou Senha inválidos");
			return "redirect:/login";
		}
	}

	@GetMapping("/login")
	public String telaLogin() {
		return "login";
	}

	@GetMapping("/apostas")
	public String telaAposta() {
		return "apostas";
	}

}
