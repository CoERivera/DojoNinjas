package com.christopherrivera.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christopherrivera.dojoandninjas.models.Dojo;
import com.christopherrivera.dojoandninjas.models.Ninja;
import com.christopherrivera.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	NinjaRepository ninjaRepository;

	// Get all ninjas
	public List<Ninja> getAllNinjas() {
		return ninjaRepository.findAll();
	}

	// Get one dojo's ninjas
	public List<Ninja> getDojoNinjas(Dojo dojo) {
		return ninjaRepository.findByDojo(dojo);
	}

	// retrieves a ninja
	public Ninja findOneNinja(Long id) {
		return ninjaRepository.findById(id).orElse(null);
	}

	// Save ninja (update/create)
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	// Delete a ninja
	public void deleteNinja(Long id) {
		if (ninjaRepository.findById(id).isPresent()) {
			ninjaRepository.deleteById(id);
		}
	}

}