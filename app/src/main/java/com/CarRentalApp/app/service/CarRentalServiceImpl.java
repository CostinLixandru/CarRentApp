package com.CarRentalApp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CarRentalApp.app.dao.CarRepository;
import com.CarRentalApp.app.entity.Car;

@Service
public class CarRentalServiceImpl implements CarRentalService{
  
   private CarRepository carRepository;
   
   public CarRentalServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;   
   }
   
   @Override
   public List<Car> findAll(){
      return carRepository.findAll();
   }
   
   @Override
   public Car findById(int n){
        Optional<Car> result = carRepository.findById(n);
        
        Car car = null;
        
        if(result.isPresent()){
            car=result.get();
        }else{
            throw new RuntimeException("the id " + n + " is not found");
        }
        return car;
        
   }
   @Override
   public void save(Car car){
        carRepository.save(car);
   
   }
   
   @Override
   public void deleteById(int n){
        carRepository.deleteById(n);
   }
          

}