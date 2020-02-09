package com.CarRentalApp.app.service;

import java.util.List;

import com.CarRentalApp.app.entity.Car;

public interface CarRentalService {
	
	public List<Car> findAll();
	
	public Car findById(int theId);
	
	public void save(Car car);
	
	public void deleteById(int theId);

}
