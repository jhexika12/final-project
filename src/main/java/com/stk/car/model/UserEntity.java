package com.stk.car.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity of Login table.
 * 
 * @author Yessica GC
 *
 */
@Entity
@Table(name = "USER")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "USERNAME", columnDefinition = "VARCHAR", length = 20)
	private String username;
	
	@Column(name = "PASSWORD", columnDefinition = "VARCHAR", length = 20)
	private String password;

	
	/**
	 * 
	 * Super Class of not accepting two equals username
	 */
	
	

	public UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public UserEntity() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username
				+ ", password=" + password + "]";
	}

	
}
