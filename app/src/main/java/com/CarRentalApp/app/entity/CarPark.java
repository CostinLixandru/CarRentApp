package com.CarRentalApp.app.entity;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.CarRentalApp.app.service.CarRentalService;

public class CarPark {
	

	private HashMap<Car,Integer> carsForRental;

	private CarRentalService carRentalService;
  
	@Autowired  
	public CarPark(CarRentalService carRentalService){       
		this.carRentalService = carRentalService;
	}
  
	@Bean
    public void populateCarsForRental(){
		List<Car> tempList = carRentalService.findAll();
      
		for(Car car : tempList){
			if(!this.carsForRental.containsKey(car)) {
				this.carsForRental.put(car, 1);
			}else {
				this.carsForRental.put(car, this.carsForRental.get(car)+1);
			}           
		}
	}

}