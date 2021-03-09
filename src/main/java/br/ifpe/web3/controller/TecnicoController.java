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

import br.ifpe.web3.dados.TecnicoDAO;
import br.ifpe.web3.model.Tecnico;

@Controller
public class TecnicoController {

	@Autowired
	private TecnicoDAO tecnicoDAO;

	@GetMapping("tecnicos")
	public ModelAndView Tecnico() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Tecnicos/tecnicos");
		mv.addObject("ListagemTecnicos", this.tecnicoDAO.findAll(Sort.by("nome")));
		return mv;
	}

	@GetMapping("add-tecnico")
	public ModelAndView AdicionarTecnico() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("tecnico", new Tecnico());
		mv.setViewName("Tecnicos/addTecnico");
		return mv;
	}
	
	@PostMapping("addTecnico")
	public ModelAndView AdicionarTecnico(@Valid Tecnico tecnico, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("tecnico", new Tecnico());

		if (br.hasErrors()) {
			mv.setViewName("Tecnico/add-tecnico");
		} else {
			this.tecnicoDAO.save(tecnico);
			mv.setViewName("redirect:tecnicos");
		}
		return mv;
	}

	@PostMapping("pesquisarTecnico")
	public ModelAndView PesquisarTecnico(String nome) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Tecnicos/tecnicos");
		List<Tecnico> pesquisaTecnicos = this.tecnicoDAO.findByNamedQuery(nome);
		mv.addObject("pesquisaTecnicos", pesquisaTecnicos);
		return mv;
	}

	@GetMapping("alterar_tec")
	public ModelAndView AlterarTecnico(Integer id) {
		ModelAndView mv = new ModelAndView();
		Tecnico tec = this.tecnicoDAO.getOne(id);
		mv.addObject("tecnico", tec);
		mv.setViewName("Tecnicos/addTecnico");
		return mv;
	}

	@GetMapping("/deletar_tec")
	public ModelAndView DeletarTecnico(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Tecnicos/tecnicos");
		this.tecnicoDAO.deleteById(id);
		return mv;
	}
}
