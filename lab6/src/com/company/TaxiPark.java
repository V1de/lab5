package com.company;

import java.util.ArrayList;

public class TaxiPark {
    private ArrayList<Vehicle> vehicles;

    TaxiPark(){
        vehicles=new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public int getCost(){
        int cost=0;
        for (Vehicle v : vehicles){
            cost+=v.getPrice();

        }
        return cost;
    }

    public void sortByFuelUsing(){
        vehicles.sort(Vehicle.fuelUsingASC);
    }

    public Vehicle getVehicleBySpeedRange(int from, int to){
        for(Vehicle o: vehicles) {
            if (o.getSpeed() >= from && o.getSpeed() <= to) return o;
        }
        return null;
    }

    @Override
    public String toString(){
        String s = "";
        for(Vehicle o: vehicles) {
        s += o.toString()+"\n";
        }
        return s;
    }
}
