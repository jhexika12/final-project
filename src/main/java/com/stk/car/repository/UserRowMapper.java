package com.stk.car.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stk.car.model.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity> {

	public UserEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new UserEntity(resultSet.getString("Username"),resultSet.getString("Password"));
	}

}
