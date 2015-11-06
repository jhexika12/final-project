package com.stk.car.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User Data Entity (customer)
 * 
 * @author Yessica GC
 *
 */
@Entity
@Table(name="USER_DATA")
public class UserDataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name= "NAME", columnDefinition="VARCHAR", length=30)
	private String name;
	
	@Column(name= "LAST_NAME", columnDefinition="VARCHAR", length=30)
	private String lastName;
	
	@Column(name= "ADDRESS", columnDefinition="VARCHAR", length=50)
	private String address;
	
	@Column(name= "PHONE", columnDefinition="VARCHAR", length=12)
	private String phone;
	
	@Column(name= "EMAIL", columnDefinition="VARCHAR", length=30)
	private String email;
	
	
	@OneToOne(optional=false)
	@JoinColumn(name="USER_ID", nullable = false)
	private UserEntity userEntity;

	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	
	public UserDataEntity() {
		super();
	}


	

	public UserDataEntity(String name, String lastName, String address,
			String phone, String email) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}


	@Override
	public String toString() {
		return "UserDataEntity [id=" + id + ", name=" + name + ", lastName="
				+ lastName + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", userEntity=" + userEntity + "]";
	}
	

}
