	package br.ifpe.web3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ifpe.web3.dados.JogadorDAO;
import br.ifpe.web3.dados.TimeDAO;
import br.ifpe.web3.model.Jogador;

@Controller
public class JogadorController {

	@Autowired
	private JogadorDAO jogadorDAO;
	
	@Autowired
	private TimeDAO timeDAO;
	
	@GetMapping("jogadores")
	public ModelAndView jogadores() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Jogadores/jogadores");			
		mv.addObject("ListagemJogadores", this.jogadorDAO.findAll(Sort.by("id")));
		return mv;
	}
	
	@GetMapping("add-jogador")
	public ModelAndView AddJogador() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Jogadores/add_jogador");
		mv.addObject("jogador", new Jogador());
		mv.addObject("AllTimes", this.timeDAO.findAll());
		return mv;
	}
	
	@PostMapping("addJogador")
	public ModelAndView AdicionarJogador(@Valid Jogador jogador, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("jogador", new Jogador());
		
		if(br.hasErrors()) {
			mv.setViewName("Jogadores/add-jogador");
		} else {
			jogadorDAO.save(jogador);
			mv.setViewName("redirect:jogadores");
		}
		return mv;
	}
	
	@PostMapping("pesquisarJogador")
	public ModelAndView PesquisarJogador(String nome) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Jogadores/jogadores");
		List<Jogador> pesquisaJogadores = jogadorDAO.findByNamedQuery(nome);
		mv.addObject("pesquisaJogadores", pesquisaJogadores);
		return mv;
	}
	
	@GetMapping("alterar")
	public ModelAndView AlterarJogador(Integer id) {
		ModelAndView mv = new ModelAndView();
		Jogador jog = this.jogadorDAO.getOne(id);
		mv.addObject("jogador", jog);
		mv.addObject("AllTimes", this.timeDAO.findAll());
		mv.setViewName("Jogadores/add_jogador");
		return mv;
	}
	
	@GetMapping("deletar")
	public ModelAndView DeletarJogador(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Jogadores/jogadores");
		this.jogadorDAO.deleteById(id);
		return mv;
	}
	
	
}
