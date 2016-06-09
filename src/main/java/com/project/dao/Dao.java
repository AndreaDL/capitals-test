package com.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class Dao {
	
	private static final String STATECAPITAL = 
			"select ctry.name as countryName, city.name as cityName "
			+ "from country as ctry join city as city "
			+ "on ctry.Capital = city.ID "
			+ "where ctry.continent in ( :continent ) ;";
	
	private static final String ALL_CONTINENT = 
			"select distinct Continent "
			+ "from Country "
			+ "where Continent != 'Antarctica';";
	
	private static final String ALL_CAPITALS = 
			"select city.Name as Capitals " +
			"from city inner join country " +
			"on city.ID = country.Capital ; ";
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplateNp;
	
	public Map<String, String> metodo(List<String> continent){

		Map<String, String> countryCity = new HashMap<String, String>();
		
		SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue("continent", continent);
		
		jdbcTemplateNp.query(STATECAPITAL, namedParameters, 
				new RowMapper<String>(){
			public String mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				countryCity.put(rs.getString("countryName"), rs.getString("cityName"));
				return null;
			}
		});
		return countryCity;
	}
	
	public List<String> listAllContinent(){
		
		return jdbcTemplateNp.query(ALL_CONTINENT, (SqlParameterSource) null, 
				new RowMapper<String>(){
			public String mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				return rs.getString("Continent");
			}
		});
	}
	
	public List<String> listAllCapitals(){
		
		return jdbcTemplateNp.query(ALL_CAPITALS, (SqlParameterSource) null, 
				new RowMapper<String>(){
			public String mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				return rs.getString("Capitals");
			}
		});
	}
	
}
