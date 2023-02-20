package com.christopherrivera.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.christopherrivera.dojoandninjas.models.Dojo;
import com.christopherrivera.dojoandninjas.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoService;
	
	@GetMapping(value={"/", "/dojos"})
	public String index(Model model) {
		List<Dojo> dojos = dojoService.getAllDojos();
		
		model.addAttribute("dojos", dojos);
		return "dojos/index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojos/newDojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojos/newDojo.jsp";
		} else {
			dojoService.saveDojo(dojo);
		}
		return "redirect:/dojos";

	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "dojos/showDojo.jsp";
	}
	
	@GetMapping("/dojos/{id}/edit")
	public String editDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "dojos/editDojo.jsp";
	}
	
	@PutMapping("/dojos/{id}")
	public String updateDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojos/editDojo.jsp";
		} else {
			dojoService.saveDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
	@DeleteMapping("/dojos/{id}")
    public String destroyDojo(@PathVariable("id") Long id) {
        dojoService.deleteDojo(id);
        return "redirect:/dojos";
    }
	
}
