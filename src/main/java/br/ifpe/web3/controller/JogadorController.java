	package br.ifpe.web3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web3.dados.JogadorDAO;
import br.ifpe.web3.dados.TimeDAO;
import br.ifpe.web3.model.Jogador;

@Controller
public class JogadorController {

	@Autowired
	private JogadorDAO jogadorDAO;
	
	@Autowired
	private TimeDAO timeDAO;

	@PostMapping("/save_jogador")
	public String savejogador(Jogador jogador) {
		this.jogadorDAO.save(jogador);

		return "redirect:/";
	}

	@GetMapping("/edit_jogador")
	public String editarJogador(Model model, Integer id) {
		Jogador jogador = this.jogadorDAO.getOne(id);
		model.addAttribute("jogador", jogador);
		model.addAttribute("lista_times", this.timeDAO.findAll());

		return "jogador";
	}

	@GetMapping("del_jogador")
	public String deletarJogador(Integer id) {
		this.jogadorDAO.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/jogador")
	public String pagjogador(Model model) {
		Jogador jogador = new Jogador();
		
		model.addAttribute("lista_times", this.timeDAO.findAll());
		model.addAttribute("jogador", jogador);

		return "jogador";
	}
	
}
