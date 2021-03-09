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
import br.ifpe.web3.dados.TecnicoDAO;
import br.ifpe.web3.dados.TimeDAO;
import br.ifpe.web3.model.Time;
import br.ifpe.web3.model.UF;

@Controller
public class TimeController {

	@Autowired
	private TimeDAO timeDAO;
	@SuppressWarnings("unused")
	@Autowired
	private TecnicoDAO tecnicoDAO;
	@SuppressWarnings("unused")
	@Autowired
	private JogadorDAO jogadorDAO;

	@GetMapping("times")
	public ModelAndView Times() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Times/times");
		mv.addObject("ListagemTimes", this.timeDAO.findAll(Sort.by("id")));		
		return mv;
	}
	
	@GetMapping("add-time")
	public ModelAndView AddTime() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Times/add_time");
		mv.addObject("time", new Time());
		mv.addObject("AllUfs", UF.values());
		mv.addObject("AllTecnicos", this.tecnicoDAO.findAll(Sort.by("nome")));
		return mv;
	}
	
	@PostMapping("addTime")
	public ModelAndView AdicionarTime(@Valid Time time, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("time", new Time());
		
		if(br.hasErrors()) {
			mv.setViewName("Times/add-time");
		} else {
			this.timeDAO.save(time);
			return Times();
		}
		return mv;
	}
	
	@PostMapping("pesquisarTime")
	public ModelAndView PesquisarTime(String nome) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Times/times");
		List<Time> pesquisaTimes = this.timeDAO.findByNamedQuery(nome);
		mv.addObject("pesquisaTimes", pesquisaTimes);
		return mv;
	}
	
	@GetMapping("alterar_time")
	public ModelAndView AlterarTime(Integer id) {
		ModelAndView mv = new ModelAndView();
		Time time = this.timeDAO.getOne(id);
		mv.addObject("time", time);
		mv.addObject("AllUfs", UF.values());
		mv.addObject("AllTecnicos", this.tecnicoDAO.findAll(Sort.by("nome")));
		mv.setViewName("Times/add_time");
		return mv;
	}
	
	@GetMapping("deletar_time")
	public ModelAndView DeletarTime(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Times/times");
		this.timeDAO.deleteById(id);
		return mv;
	}

}
