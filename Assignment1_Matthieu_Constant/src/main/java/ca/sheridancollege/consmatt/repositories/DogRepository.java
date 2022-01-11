package ca.sheridancollege.consmatt.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import ca.sheridancollege.consmatt.beans.Dog;

@Repository
public class DogRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public void addDog(Dog dog) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		Random r = new Random();
		dog.setNumber(Math.round(11111 + (99999 - 11111)* r.nextDouble()));
		String query = "INSERT INTO dogs (number, name, owner, breed, gender, classOrSpec) VALUES (:number, :name, :owner, :breed, :gender, :classOrSpec)";
		parameters.addValue("number", dog.getNumber());
		parameters.addValue("name", dog.getName());
		parameters.addValue("owner", dog.getOwner());
		parameters.addValue("breed", dog.getBreed());
		parameters.addValue("gender", dog.getGender());
		parameters.addValue("classOrSpec", dog.getClassOrSpec());
	
				jdbc.update(query, parameters);
	}
	
	public ArrayList<Dog> getDogs() {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogs";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row: rows) {
			Dog d = new Dog();
			d.setId((Integer)row.get("id"));
			d.setNumber((Double)row.get("number"));
			d.setName((String)row.get("name"));
			d.setOwner((String)row.get("owner"));
			d.setBreed((String)row.get("breed"));
			d.setGender((String)row.get("gender"));
			d.setClassOrSpec((String)row.get("classOrSpec"));
			dogs.add(d);	
		}
		return dogs;
	}
	
	public Dog getDogById(int id) {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogs WHERE id=:id";  
		parameters.addValue("id", id);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row: rows) {
			Dog d = new Dog();
			d.setId((Integer)row.get("id"));
			d.setNumber((Double)row.get("number"));
			d.setName((String)row.get("name"));
			d.setOwner((String)row.get("owner"));
			d.setBreed((String)row.get("breed"));
			d.setGender((String)row.get("gender"));
			d.setClassOrSpec((String)row.get("classOrSpec"));
			dogs.add(d);
		}
		if(dogs.size() == 1) {
			return dogs.get(0);
		}else {
			return null;
		}
	}
	
	public void editDog(Dog dog) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "UPDATE dogs SET number=:number, name=:name, owner=:owner, breed=:breed, gender=:gender, classOrSpec=:classOrSpec WHERE id=:id";
		parameters.addValue("number", dog.getNumber());
		parameters.addValue("name", dog.getName());
		parameters.addValue("owner", dog.getOwner());
		parameters.addValue("breed", dog.getBreed());
		parameters.addValue("gender", dog.getGender());
		parameters.addValue("classOrSpec", dog.getClassOrSpec());
		parameters.addValue("id", dog.getId());
		
		jdbc.update(query, parameters);
		
	}
	
	public void deleteDog(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM dogs WHERE id=:id";
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
	}
	
	/**public ArrayList<Dog> showList() {
		ArrayList<Dog> stats  = new ArrayList<Dog>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT COUNT(gender) FROM dogs WHERE classOrSpec='Specialty' AND gender='Male' AND breed='Beagle';";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row : rows) {
			Dog d = new Dog();
			d.setMaleSpecialty((int)row.get("gender"));
			stats.add(d);
			
		}
	return stats;	
		} **/
	}
	
	
	
	
		

