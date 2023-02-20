package com.christopherrivera.dojoandninjas.controllers;

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

import com.christopherrivera.dojoandninjas.models.Ninja;
import com.christopherrivera.dojoandninjas.services.DojoService;
import com.christopherrivera.dojoandninjas.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	DojoService dojoService; 
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.getAllDojos());
		return "ninjas/newNinja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.getAllDojos());
			return "ninjas/newNinja.jsp";
		} else {
			ninjaService.saveNinja(ninja);
		}
		return "redirect:/dojos";

	}
	
	@GetMapping("/ninjas/{id}/edit")
	public String editNinja(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojos", dojoService.getAllDojos());
		model.addAttribute("ninja", ninjaService.findOneNinja(id));
		return "ninjas/editNinja.jsp";
	}
	
	@PutMapping("/ninjas/{id}")
	public String updateNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.getAllDojos());
			return "ninjas/editNinja.jsp";
		} else {
			ninjaService.saveNinja(ninja);
		}
		return "redirect:/dojos";

	}
	
	@DeleteMapping("/ninjas/{id}")
    public String destroyDojo(@PathVariable("id") Long id) {
        ninjaService.deleteNinja(id);
        return "redirect:/dojos";
    }
	
	
}
