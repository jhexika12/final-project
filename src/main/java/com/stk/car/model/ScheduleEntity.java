package com.stk.car.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SCHEDULE")
public class ScheduleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name= "DATE", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR", length = 200)
	private String description;
	
	@ManyToOne
    @OrderColumn
    @JoinColumn(name = "USER_ID")
	private UserEntity userEntity;
	
	@ManyToOne
    @OrderColumn
    @JoinColumn(name = "CAR_DATA_ID")
	private CarDataEntity carDataEntity;
	
	@ManyToOne
    @OrderColumn
    @JoinColumn(name = "ENGINEER_INFO_ID")
	private EngineerInfoEntity engineerInfoEntity;

	public Integer getId() {
		return id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public CarDataEntity getCarDataEntity() {
		return carDataEntity;
	}

	public void setCarDataEntity(CarDataEntity carDataEntity) {
		this.carDataEntity = carDataEntity;
	}

	public EngineerInfoEntity getEngineerInfoEntity() {
		return engineerInfoEntity;
	}

	public void setEngineerInfoEntity(EngineerInfoEntity engineerInfoEntity) {
		this.engineerInfoEntity = engineerInfoEntity;
	}


	public ScheduleEntity(Integer id, Date date, String description) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
	}


	public ScheduleEntity() {
		super();

	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ScheduleEntity other = (ScheduleEntity) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ScheduleEntity [id=" + id + ", date=" + date + ", description="
				+ description + ", userEntity=" + userEntity
				+ ", carDataEntity=" + carDataEntity + ", engineerInfoEntity="
				+ engineerInfoEntity + "]";
	}

	
	
	
}
