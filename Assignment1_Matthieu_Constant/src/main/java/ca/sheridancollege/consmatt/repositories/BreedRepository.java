package ca.sheridancollege.consmatt.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.consmatt.beans.BreedBean;



@Repository
public class BreedRepository {
	

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public void addBreed(BreedBean breed) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO breeds (name) VALUES (:name)";
		parameters.addValue("name", breed.getName());
		jdbc.update(query, parameters);
	}
	
	
	public ArrayList<BreedBean> getBreeds() {
	ArrayList<BreedBean>breeds = new ArrayList<BreedBean>();
	MapSqlParameterSource parameters = new MapSqlParameterSource();
	String query = "SELECT * FROM breeds";
	
	List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
	 
	for (Map<String, Object> row : rows) {
		BreedBean d = new BreedBean();
		d.setName((String)row.get("name"));
		breeds.add(d);
		
	}
	return breeds;
}
	
	
}
