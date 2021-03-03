package br.ifpe.web3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web3.dados.TecnicoDAO;
import br.ifpe.web3.model.Tecnico;

@Controller
public class TecnicoController {

	@Autowired
	private TecnicoDAO tecnicoDAO;

	@PostMapping("/save_tecnico")
	public String saveTecnico(Tecnico tecnico) {
		this.tecnicoDAO.save(tecnico);

		return "redirect:/";
	}

	@GetMapping("/edit_tecnico")
	public String editarTecnico(Model model, Integer id) {
		Tecnico tec = this.tecnicoDAO.getOne(id);
		model.addAttribute("tecnico", tec);
		model.addAttribute("mensagem", null);
		return "tecnico";
	}
	
	@GetMapping("/del_tecnico")
	public String deletarTecnico(Integer id) {
		this.tecnicoDAO.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/tecnico")
	public String pagTecnico(Model model) {
		Tecnico tecnico = new Tecnico();
		model.addAttribute("tecnico", tecnico);

		return "tecnico";
	}
	
	
}
