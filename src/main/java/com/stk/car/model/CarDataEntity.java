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

@Entity
@Table(name="CAR_DATA")
public class CarDataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "BRAND", columnDefinition = "VARCHAR", length = 30)
	private String brand;
	
	@Column(name = "MODEL", columnDefinition = "VARCHAR", length = 30)
	private String model;
	
	@Column(name = "COLOR", columnDefinition = "VARCHAR", length = 30)
	private String color;
	
	@ManyToOne
    @OrderColumn
    @JoinColumn(name = "USER_ID")
	private UserEntity userEntity;

}
