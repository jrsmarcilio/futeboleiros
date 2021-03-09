package br.ifpe.web3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApostasController {

 @GetMapping("/apostas")
 public ModelAndView apostas() {
	 ModelAndView mv = new ModelAndView();
	 mv.setViewName("Apostas/apostas");
	 return mv;
 }
	
}
