package com.stk.car.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stk.car.model.UserEntity;

@Repository
public class UserRepository {
	
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserRepository(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void createUser(UserEntity userEntity){
		this.jdbcTemplate.update
			("INSERT INTO USER(Username,Password) VALUES(?,?)"
					,userEntity.getUsername(),userEntity.getPassword());
	}
	
	@SuppressWarnings("rawtypes")
	public UserEntity findUserByUsername(String username){
		UserEntity userEntity = null;
		Map rowMap = this.jdbcTemplate.queryForMap("SELECT * FROM USER WHERE Username = ?",username);
		
		if(rowMap != null)
			userEntity = new UserEntity((String)rowMap.get("username"),(String)rowMap.get("password"));
		
		return userEntity;
		
	}
	
	public List<UserEntity> findAllUsers(){
		
		return this.jdbcTemplate.query("SELECT * FROM USER", new UserRowMapper());
	}
	
}
