package br.com.lnprojetos.bpplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lnprojetos.bpplanner.repository.Projeto;
import br.com.lnprojetos.bpplanner.repository.ProjetoRepository;

@Controller
public class HomeController {
	
	@Autowired
	ProjetoRepository projetoRepository;

	@RequestMapping("/home")
	public @ResponseBody List<Projeto> getHome() {
		
		projetoRepository.save(new Projeto());
		
		return projetoRepository.findAll();
	}
}