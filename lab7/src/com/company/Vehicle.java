package com.company;

import java.util.Comparator;
import java.util.Objects;

public class Vehicle {
    private String name;
    private int price;
    private double fuelUsing;
    private int speed;

    public Vehicle(String name,int price,double fuelUsing,int speed){
        this.name = name;
        this.price=price;
        this.fuelUsing=fuelUsing;
        this.speed=speed;

    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public Double getFuelUsing(){
        return fuelUsing;
    }

    public int getSpeed(){
        return speed;
    }

    public static Comparator<Vehicle> fuelUsingASC = new Comparator<Vehicle>(){
        public int compare(Vehicle v1, Vehicle v2){
            return v1.getFuelUsing().compareTo(v2.getFuelUsing());
        }
    };


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return price == vehicle.price &&
                Double.compare(vehicle.fuelUsing, fuelUsing) == 0 &&
                speed == vehicle.speed &&
                Objects.equals(name, vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, fuelUsing, speed);
    }

    @Override
    public String toString(){
        String s = "";
        s += "name: " + name + "\n";
        s += "price: " + price + "\n";
        s += "Fuel Using: " + fuelUsing + "\n";
        s += "Speed: " + speed + "\n";
        return s;
    }
}
