package com.company;

import java.util.Comparator;

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
    public String toString(){
        String s = "";
        s += "name: " + name + "\n";
        s += "price: " + price + "\n";
        s += "Fuel Using: " + fuelUsing + "\n";
        s += "Speed: " + speed + "\n";
        return s;
    }
}
