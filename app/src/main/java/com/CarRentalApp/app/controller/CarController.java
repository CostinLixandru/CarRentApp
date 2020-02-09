package com.CarRentalApp.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CarRentalApp.app.entity.Car;
import com.CarRentalApp.app.service.CarRentalService;

@Controller
@RequestMapping("/rentalcars")
public class CarController {
	
		private CarRentalService carRentalService;
		
		public CarController(CarRentalService carRentalService) {
			this.carRentalService = carRentalService;
		}
		
		@GetMapping("/list")
		public String listCars(Model model) {
			List<Car> cars = carRentalService.findAll();
			model.addAttribute("cars", cars);
			return "rentalcars/listcars";
		}
		
		@GetMapping("/saveCarPage")
		public String saveCar(Model model) {
			Car car = new Car();
			model.addAttribute("car", car);			
			return "rentalcars/savecars";
		}
		@GetMapping("/updateCar")
		public String updateCar(@RequestParam("carId") int id,Model model) {
			Car car = this.carRentalService.findById(id);	
			model.addAttribute("car", car);		
			return "rentalcars/savecars";
		}
		
		@GetMapping("/deleteCar")
		public String deleteCar(@RequestParam("carId") int id) {
			this.carRentalService.deleteById(id);	
			return "redirect:/rentalcars/list";
		}
		
		@PostMapping("/save")
		public String saveEmployee(@ModelAttribute("car") Car car) {			   
			carRentalService.save(car);
			return "redirect:/rentalcars/list";
		}

}
