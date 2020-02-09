package com.CarRentalApp.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CarRentalApp.app.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
