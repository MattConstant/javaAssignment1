package ca.sheridancollege.consmatt.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.consmatt.beans.BreedBean;

import ca.sheridancollege.consmatt.repositories.BreedRepository;



@Controller
public class BreedController {
	
	static ArrayList<BreedBean> breeds = new ArrayList<BreedBean>();
	
	@Autowired
	private BreedRepository breedRepo;
	

	@GetMapping("/addBreed")
	public String loadAddDrinkPage(Model model) {
		model.addAttribute("breed", new BreedBean());
		return "addBreed.html";
	}
	
	
	@PostMapping("/addBreed")
	public String addBreed(@ModelAttribute BreedBean breed, Model model) {
		System.out.println(breed);
		model.addAttribute("drink", new BreedBean());
		breeds.add(breed);
		
		breedRepo.addBreed(breed);
		
		return"redirect:/addBreed";
	}

	@GetMapping("/displayBreeds")
	public String displayBreeds(Model model) {
		model.addAttribute("myBreeds", breedRepo.getBreeds());
		return "viewBreed.html";
	}
}
	
	

