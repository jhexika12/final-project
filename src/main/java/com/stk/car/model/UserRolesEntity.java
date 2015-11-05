package com.stk.car.model;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Table(name = "USER_ROLES")
public class UserRolesEntity {
	
	@ManyToMany
	@JoinTable(name = "USER_ROLES", 
		joinColumns = @JoinColumn(name="USER_ID", referencedColumnName ="ID"), 
		inverseJoinColumns = @JoinColumn(name="ROLE_ID",referencedColumnName = "ID"))
	private List<RoleEntity> roles;

}
