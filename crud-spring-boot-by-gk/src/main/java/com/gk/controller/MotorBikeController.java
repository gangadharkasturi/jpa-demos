package com.gk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gk.entity.MotorBike;
import com.gk.service.MotorBikeService;

/**
 * 
 * @author Gangadhar Kasturi
 *
 */
@RestController
public class MotorBikeController {
	//@Autowired
	public MotorBikeService motorBikeService = new MotorBikeService();;

	@GetMapping(value = "/findMotorBikeById/{id}")
	public MotorBike findMotorBikeById(@PathVariable long bikeId) {
		MotorBike motorBike = motorBikeService.getMotorBikeById(bikeId);
		return motorBike;
	}
	@PostMapping
	public String saveMotorBike(@RequestBody MotorBike motorBike) {
		return motorBikeService.insertMotorBike(motorBike);
	}
	

}
