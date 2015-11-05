package com.stk.car.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User Role entity
 * 
 * @author Yessica GC
 *
 */
@Table(name = "USER_ROLES")
public class RoleEntity {
	
	@Column(name = "ROLE", columnDefinition = "VARCHAR", length = 45)
	private String role;
	
	@Column(name = "USERNAME", columnDefinition = "VARCHAR", length = 45 )
	private String username;
	
	@OneToOne(optional=false)
	@JoinColumn(name="USER_ID", nullable = false)
	private UserEntity userEntity;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public RoleEntity(String role, String username, UserEntity userEntity) {
		super();
		this.role = role;
		this.username = username;
		this.userEntity = userEntity;
	}

	public RoleEntity() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result
				+ ((userEntity == null) ? 0 : userEntity.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleEntity other = (RoleEntity) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userEntity == null) {
			if (other.userEntity != null)
				return false;
		} else if (!userEntity.equals(other.userEntity))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoleEntity [role=" + role + ", username=" + username
				+ ", userEntity=" + userEntity + "]";
	}
	
	
}
