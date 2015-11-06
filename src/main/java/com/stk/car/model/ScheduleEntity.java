package com.stk.car.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


/**
 * Schedule Enity
 * 
 * @author Yessica GC
 *
 */
@Entity
@Table(name = "SCHEDULE")
public class ScheduleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "DATE_CAR", columnDefinition = "VARCHAR", length = 30)
	private String date_car;
	
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

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate_car() {
		return date_car;
	}

	public void setDate_car(String date_car) {
		this.date_car = date_car;
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

	public ScheduleEntity(String date_car, String description,
			UserEntity userEntity, CarDataEntity carDataEntity,
			EngineerInfoEntity engineerInfoEntity) {
		super();
		this.date_car = date_car;
		this.description = description;
		this.userEntity = userEntity;
		this.carDataEntity = carDataEntity;
		this.engineerInfoEntity = engineerInfoEntity;
	}

	public ScheduleEntity() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((carDataEntity == null) ? 0 : carDataEntity.hashCode());
		result = prime * result
				+ ((date_car == null) ? 0 : date_car.hashCode());
		result = prime
				* result
				+ ((engineerInfoEntity == null) ? 0 : engineerInfoEntity
						.hashCode());
		result = prime * result
				+ ((userEntity == null) ? 0 : userEntity.hashCode());
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
		if (carDataEntity == null) {
			if (other.carDataEntity != null)
				return false;
		} else if (!carDataEntity.equals(other.carDataEntity))
			return false;
		if (date_car == null) {
			if (other.date_car != null)
				return false;
		} else if (!date_car.equals(other.date_car))
			return false;
		if (engineerInfoEntity == null) {
			if (other.engineerInfoEntity != null)
				return false;
		} else if (!engineerInfoEntity.equals(other.engineerInfoEntity))
			return false;
		if (userEntity == null) {
			if (other.userEntity != null)
				return false;
		} else if (!userEntity.equals(other.userEntity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScheduleEntity [id=" + id + ", date_car=" + date_car
				+ ", description=" + description + ", userEntity=" + userEntity
				+ ", carDataEntity=" + carDataEntity + ", engineerInfoEntity="
				+ engineerInfoEntity + "]";
	}

	

	
	
	
}
