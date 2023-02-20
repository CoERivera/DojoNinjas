package com.christopherrivera.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christopherrivera.dojoandninjas.models.Dojo;
import com.christopherrivera.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	DojoRepository dojoRepository;
	
	//returns all the dojo
	public List<Dojo> getAllDojos(){
		return dojoRepository.findAll();
	}
	
	//creates or updates a dojo
	public Dojo saveDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	//retrieves a dojo
	public Dojo findDojo(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}
	
	//deletes a dojo
	public void deleteDojo(Long id) {
		if(dojoRepository.findById(id).isPresent()) {
			dojoRepository.deleteById(id);
		}
	}
}