package br.ifpe.web3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web3.dados.JogadorDAO;
import br.ifpe.web3.dados.TecnicoDAO;
import br.ifpe.web3.dados.TimeDAO;
import br.ifpe.web3.model.Jogador;
import br.ifpe.web3.model.Time;
import br.ifpe.web3.model.UF;

@Controller
public class TimeController {

	@Autowired
	private TimeDAO timeDAO;
	@Autowired
	private TecnicoDAO tecnicoDAO;
	@Autowired
	private JogadorDAO jogadorDAO;

	@PostMapping("/save_time")
	public String saveTime(Time time) {
		if(time.getNome().trim().isEmpty()) return "redirect:/time";
		
		this.timeDAO.save(time);
		return "redirect:/";
	}

	@GetMapping("/edit_time")
	public String editarTime(Model model, Integer id) {
		Time time = this.timeDAO.getOne(id);
		model.addAttribute("time", time);
		model.addAttribute("lista_ufs", UF.values());
		model.addAttribute("lista_tecs", this.tecnicoDAO.findAll());
		return "time";
	}
	
	@GetMapping("/time")
	public String pagTime(Model model) {
		Time time = new Time();
		model.addAttribute("lista_tecs", this.tecnicoDAO.findAll());
		model.addAttribute("time", time);
		model.addAttribute("lista_ufs", UF.values());
		
		return "time";
	}
	
	@GetMapping("/del_time")
	public String deletarTime(Integer id) {
		this.timeDAO.deleteById(id);
		return "redirect:/";
	}
	
	@PostMapping("/find")
	public String findName(String nome, Integer pesquisa, Model model) {
		
		if(pesquisa == 1) {			
		List<Jogador> jogNome =  this.jogadorDAO.findByNamedQuery(nome);
		model.addAttribute("lista_jogs", jogNome);
		
		model.addAttribute("lista_times", this.timeDAO.findAll());
		model.addAttribute("lista_tecs", this.tecnicoDAO.findAll());
		return "index";
		} else if(pesquisa == 2) {
			Time time = this.timeDAO.findByClubQuery(nome);
			
			List<Jogador> jogTime = this.jogadorDAO.findByClubQuery(time.getId());
			System.out.println("nome " + nome + pesquisa);
			model.addAttribute("lista_jogs", jogTime);
			
			model.addAttribute("lista_times", this.timeDAO.findAll());
			model.addAttribute("lista_tecs", this.tecnicoDAO.findAll());
			return "index";
		}
		
		return "index";
		
	}
	
	/* Página Inicial */
	@GetMapping("/ini")
	public String index(Model model) {
		model.addAttribute("lista_tecs", this.tecnicoDAO.findAll());
		model.addAttribute("lista_jogs", this.jogadorDAO.findAll(Sort.by("nome")));
		model.addAttribute("lista_times", this.timeDAO.findAll());
		return "index";
	}
	
}
