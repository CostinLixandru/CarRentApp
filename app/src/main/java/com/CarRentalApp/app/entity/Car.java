package com.CarRentalApp.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carrental")
public class Car{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="carbrand")
    private String brand;
    
    @Column(name="cartype")
    private String type;
	
    @Column(name="color")
    private String color;
    

    @Column(name="no_km") 
    private int noKm;

    
    public Car() {
    	
    }

    public Car(int id, String brand, String type, String color, int noKm){
    	this.id = id;
    	this.brand = brand;
    	this.type = type;
		this.color=color;
		this.noKm = noKm;
    }

	public Car(String brand, String type, String color, int noKm){
		this.brand = brand;
		this.type = type;
		this.color = color;
		this.noKm = noKm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNoKm() {
		return noKm; 
	}
	  
	public void setNoKm(int noKm) { 
	  this.noKm = noKm; 
	}
	 
	@Override
	public boolean equals(Object obj) {	 
	    if (obj == null) {
	      return false;
	    }	 
	    if (this.getClass() != obj.getClass()) {
	      return false;
	    }	 
	    Car carObj = (Car)obj;
	    if (super.equals(carObj) && 
	        this.brand.equals(carObj.brand) &&
	        this.type.equals(carObj.type)) {
	      return true;
	    }	 
	    return false;
	  }
	
	  @Override
	  public int hashCode() {		  
	    int prime = 31;
	    int result = super.hashCode();
	    result = prime * result + ((brand == null) ? 0 : brand.hashCode());
	    result = prime * result + ((type == null) ? 0 : type.hashCode());
	    return result;    
	  }

	@Override
	public String toString() {
		return "Car [id=" + id + ", Brand=" + brand + ", type=" + type + " color " +color+ ", noKm =" + noKm + "]";
	}
}