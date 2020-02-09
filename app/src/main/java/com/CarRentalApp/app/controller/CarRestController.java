package com.CarRentalApp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalApp.app.entity.Car;
import com.CarRentalApp.app.service.CarRentalService;

@RestController
@RequestMapping("/api")
public class CarRestController {

	private CarRentalService carRentalService;
	
	@Autowired
	public CarRestController(CarRentalService carRentalService) {
		this.carRentalService = carRentalService;
	}
	
	@GetMapping("/cars")
	public List<Car> findAll() {
		return this.carRentalService.findAll();
	}
	
	@GetMapping("/cars/{id}")
	public Car getCar(@PathVariable int id) {		
		Car car = this.carRentalService.findById(id);		
		if (car == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}		
		return car;
	}
	
	@PostMapping("/cars")
	public Car addEmployee(@RequestBody Car car) {			
		car.setId(0); // pentru a salva o masina noua		
		this.carRentalService.save(car);		
		return car;
	}
	
	@PutMapping("/cars")
	public Car updateEmployee(@RequestBody Car car) {		
		this.carRentalService.save(car);		
		return car;
	}
	
	@DeleteMapping("/cars/{id}")
	public String deleteEmployee(@PathVariable int id) {		
		Car tempCar = this.carRentalService.findById(id);	
		if (tempCar == null) {
			throw new RuntimeException("Id for rental car not found - " + id);
		}		
		this.carRentalService.deleteById(id);		
		return "Deleted car id - " + id;
	}

}
