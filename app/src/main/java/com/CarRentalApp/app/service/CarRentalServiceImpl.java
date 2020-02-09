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
        return findAll().get(n);
        
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