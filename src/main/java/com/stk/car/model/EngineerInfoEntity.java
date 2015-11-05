package com.stk.car.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Entity of Engineer information
 * 
 * 
 * @author Yessica GC
 *
 */

@Entity
@Table(name= "ENGINEER_INFO")
public class EngineerInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR", length = 40)
	private String name;
	
	@Column(name = "PHONE", columnDefinition = "VARCHAR", length = 12)
	private String phone;
	
	@Column(name = "EMAIL", columnDefinition = "VARCHAR", length = 30)
	private String email;
	
	@Column(name = "BIRTHDAY", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR", length = 50)
	private String description;
	


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
	
	public EngineerInfoEntity() {
		super();
	}


	public EngineerInfoEntity(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}


	@Override
	public String toString() {
		return "EngineerInfoEntity [id=" + id + ", name=" + name + ", phone="
				+ phone + ", email=" + email + ", birthday=" + birthday
				+ ", description=" + description + "]";
	}

	
	
	
}
