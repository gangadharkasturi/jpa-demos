package com.kasturi.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * 
 * @author Gangadhar, Kasturi
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name=MotorBike.MOTOR_BIKE_BY_CHASSIS_NO,query=MotorBike.MOTOR_BIKE_BY_CHASSIS_NO_QUERY)
	
})
@NamedNativeQueries({
	@NamedNativeQuery(name="MOTOR_BIKE_BY_MODEL",query="SELECT * FROM MotorBike WHERE MODEL = ?",resultClass=MotorBike.class)
	
})

public class MotorBike {
	 final static String MOTOR_BIKE_BY_CHASSIS_NO = "MOTOR_BIKE_BY_CHASSIS_NO";
	 final static String MOTOR_BIKE_BY_CHASSIS_NO_QUERY = "select m.bikeId,m.model from MotorBike m where m.chassisNo = :cn";
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bikeId;
	
	private String chassisNo;
	
	private String manufacturer;
	
	private String engineNo;
	
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
