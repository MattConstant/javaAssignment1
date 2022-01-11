package ca.sheridancollege.consmatt.controllers;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.consmatt.beans.Dog;
import ca.sheridancollege.consmatt.repositories.DogRepository;

@Controller
public class DogController {
	
	static ArrayList<Dog> dogs = new ArrayList<Dog>();
	
	@Autowired
	private DogRepository dogRepo;
	
	@GetMapping("/")
	public String loadRootPage() {
		return "root.html";
	}
	
	@GetMapping("/addDog")
	public String loadAddDogPage(Model model) {
		model.addAttribute("dog", new Dog());
		return "addDog.html";
	}
	
	
	@PostMapping("/addDog")
	public String addDog(@ModelAttribute Dog dog, Model model) {
		System.out.println(dog);
		model.addAttribute("dog", new Dog());
		dogs.add(dog);
		dogRepo.addDog(dog);
		
		return"redirect:/addDog";
	}
	
	@GetMapping("/displayDogs")
	public String displayDogs(Model model) {
		model.addAttribute("myDogs", dogRepo.getDogs());
		return "viewDogs.html";
	}

	
	@GetMapping("/edit/{id}")
	public String loadEdit(@PathVariable int id, Model model) {
		Dog d = dogRepo.getDogById(id);
		model.addAttribute("dog", d);
		return "editDog.html";
	}
	
	@PostMapping("/editDog")
	public String editDog(@ModelAttribute Dog dog, Model model) {
		dogRepo.editDog(dog);
		model.addAttribute("myDogs", dogRepo.getDogs());
		return "viewDogs.html";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDog(@PathVariable int id, Model model) {
		dogRepo.deleteDog(id);
		model.addAttribute("myDogs", dogRepo.getDogs());
		return "viewDogs.html";
	}
	@GetMapping("/showList")
	public String loadAddDogPage() {
		return "showList.html";
	}
	
	
	
	
}
