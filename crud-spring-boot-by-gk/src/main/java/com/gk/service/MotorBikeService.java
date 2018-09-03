package com.gk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gk.entity.MotorBike;

/**
 * 
 * @author Gangadhar Kasturi
 *
 */
@Repository
public class MotorBikeService {

	@Autowired
	public MotorBikeRepo motorBikeRepo ;

	public String insertMotorBike(MotorBike motorBike) {
		motorBikeRepo.save(motorBike);
		return motorBike.getModel() + " successfully inserted ";
	}

	public MotorBike getMotorBikeById(long motorBikeId) {
		Object obj = motorBikeRepo.findById(motorBikeId);
		return (MotorBike) obj;
	}

	public List<MotorBike> getAllMotorBikes() {
		List<MotorBike> motorBikes = motorBikeRepo.findAll();
		return motorBikes;
	}
}
