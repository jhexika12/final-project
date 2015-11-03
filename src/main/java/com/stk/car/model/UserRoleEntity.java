package com.stk.car.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "LOGIN")
public class UserRoleEntity {
	
	@Column(name = "ROLE", columnDefinition = "VARCHAR", length = 45)
	private String role;
	
	@OneToOne(optional=false)
	@JoinColumn(name="USER_ID", nullable = false)
	private UserEntity userEntity;
}
