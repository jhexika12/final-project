package com.stk.car.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Entity of Login table.
 * 
 * @author Yessica GC
 *
 */
@Entity
@Table(name = "LOGIN")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "USERNAME", columnDefinition = "VARCHAR", length = 20)
	private String username;
	
	@Column(name = "PASSWORD", columnDefinition = "VARCHAR", length = 20)
	private String password;

	@OneToMany
	@JoinColumn(name= "USER_ID")
	private List<CarDataEntity> carDataEntity;
	
	/**
	 * 
	 * Super Class of not accepting two equals username
	 */
	public UserEntity() {
		super();
	}
	

	public UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	public List<CarDataEntity> getCarDataEntity() {
		return carDataEntity;
	}

	public void setCarDataEntity(List<CarDataEntity> carDataEntity) {
		this.carDataEntity = carDataEntity;
	}


	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username
				+ ", password=" + password + ", carDataEntity=" + carDataEntity
				+ "]";
	}

	
}
