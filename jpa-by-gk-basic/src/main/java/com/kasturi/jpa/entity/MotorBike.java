package com.kasturi.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Gangadhar, Kasturi
 *
 */
@Entity
public class MotorBike {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BIKE_ID")
	private int bikeId;
	
	@Column(name="CHASSIS_NO",nullable=false)
	private String chassisNo;
	
	@Column(name="MANUFACTURER")
	private String manufacturer;
	
	@Column(name="ENGINE_NO")
	private String engineNo;
	
	@Column(name="MODEL")
	private String model;

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "MotorBike [chassisNo=" + chassisNo + ", manufacturer=" + manufacturer + ", engineNo=" + engineNo
				+ ", bikeId=" + bikeId + ", model=" + model + "]";
	}
}
