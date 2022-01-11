package ca.sheridancollege.consmatt.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreedBean implements Serializable{

	private static final long serialVersionUID = -8006415885062036628L;
	
	private String name;




}
