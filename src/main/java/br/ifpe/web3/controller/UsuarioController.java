package br.ifpe.web3.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ifpe.web3.dados.JogadorDAO;
import br.ifpe.web3.dados.TimeDAO;
import br.ifpe.web3.model.Usuario;
import br.ifpe.web3.service.ServiceUsuario;
import br.ifpe.web3.service.ServicesExceptions;
import br.ifpe.web3.util.Util;

@Controller
public class UsuarioController {

	@Autowired
	private ServiceUsuario serviceUsuario;

	@Autowired
	private JogadorDAO jogadorDAO;
	
	@Autowired
	private TimeDAO timeDAO;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Home/index");
		return mv;
	}

	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/home");
		mv.addObject("ListagemJogadores", this.jogadorDAO.findAll());
		mv.addObject("AllTimes", this.timeDAO.findAll());
		return mv;
	}

	/* ##### LOGIN ##### */

	@GetMapping("login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@PostMapping("login")
	public ModelAndView logar(@Valid Usuario usuario, BindingResult br, HttpSession session)
			throws NoSuchAlgorithmException, ServicesExceptions {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());

		if (br.hasErrors()) {
			mv.setViewName("Login/login");
		}

		Usuario userLogin = serviceUsuario.loginUser(usuario.getUsername(), Util.md5(usuario.getSenha()));

		if (userLogin == null) {
			mv.addObject("msg", "Usuário não encontrado. Tente novamente!");
		} else {
			session.setAttribute("usuarioLogado", userLogin);
			return home();
		}

		return mv;
	}

	/* ##### LOGOUT ##### */

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return login();
	}

	/* ##### CADASTRO ##### */

	@GetMapping("cadastro")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("Login/cadastro");
		return mv;
	}

	@PostMapping("cadastro")
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult br) throws Exception {
		ModelAndView mv = new ModelAndView();

		if (br.hasErrors()) {
			mv.setViewName("Login/cadastro");
			mv.addObject("usuario", usuario);
		} else {
			mv.setViewName("redirect:/login");
			serviceUsuario.salvarUsuario(usuario);
		}

		return mv;
	}
}

/* ##### ACIMA ATUALIZADOS ##### */
