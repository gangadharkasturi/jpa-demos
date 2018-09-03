package com.gk.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gk.entity.MotorBike;
/**
 * 
 * @author Gangadhar
 *
 */
@Repository
public interface MotorBikeRepo extends JpaRepository<MotorBike, Long> {

}
