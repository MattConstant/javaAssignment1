package ca.sheridancollege.consmatt.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog implements Serializable {
	
	
	private String[] breedsList = {"Beagle", "Dachshund", "Whippet", "Corgi", "Borzoi", "Golden Retriever", "Chihuahua", "Shiba Inu", "Rottweiler", "Poodle"};
	private static final long serialVersionUID = 6130389259399341493L;
	
	
	private int id;
	private double number;
	private String name;
	private String owner;
	private String breed;
	private String gender;
	private String classOrSpec;
	
/**	private int breedAmount;
	private int maleClass;
	private int femaleClass;
	private int maleSpecialty;
	private int femaleSpecialty; **/
	
	
}
