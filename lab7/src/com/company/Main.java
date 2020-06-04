package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Vehicle lamborghiniVeneno = new SuperCar("Lamborghini Veneno", 4500000, 23,260);
        Vehicle mclarenSenna = new SuperCar("McLaren Senna", 1200000, 21,280);
        Vehicle audiA7 = new Car("Audi A7", 80000,11,240);
        Vehicle teslaModelX = new Car("Tesla Model X", 94000,0,250);
        Vehicle mercedesAMG = new Car("Mercedes AMG", 200000,14,265);
        Vehicle mulsanne = new Limousine("Mulsanne", 300000,17.5,185);
        Vehicle hummerH2 = new Limousine("Hummer H2", 70000,15.5,190);
        Vehicle cadillacEscalade = new Limousine("Cadillac Escalade", 120000,20,165);


        TaxiPark taxiPark = new TaxiPark();
        taxiPark.add(lamborghiniVeneno);
        taxiPark.add(mclarenSenna);
        taxiPark.add(audiA7);
        taxiPark.add(teslaModelX);
        taxiPark.add(mercedesAMG);
        taxiPark.add(mulsanne);
        taxiPark.add(hummerH2);
        taxiPark.add(cadillacEscalade);


        System.out.println("Unsorted cars: \n" + taxiPark.toString());
        taxiPark.sort(Vehicle.fuelUsingASC);
        System.out.println("Sorted cars: \n" + taxiPark.toString());

        Vehicle choosenCar = taxiPark.getVehicleBySpeedRange(220,250);
        if (choosenCar==null) System.out.println("Car wasn't found");
        else System.out.println("Car with a choosen speed: " + choosenCar.getName());
        System.out.println("Total cost of TaxiPark: " + taxiPark.getCost());

    }
}
