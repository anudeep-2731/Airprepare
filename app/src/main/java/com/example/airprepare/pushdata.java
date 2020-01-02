package com.example.airprepare;

public class pushdata {
    String cities;
    String taxies1;
    String taxies2;
    String hotels1;
    String hotels2;
    public pushdata(){}
    public  pushdata(String cities,
            String taxies1,
            String taxies2
            ){
        this.cities=cities;
        this.taxies1=taxies1;
        this.taxies2=taxies2;
    }
    public  pushdata(String hotels1,
                     String hotels2){
        this.hotels1=hotels1;
        this.hotels2=hotels2;
    }

    public String getCities() {
        return cities;
    }

    public String getTaxies1() {
        return taxies1;
    }

    public String getTaxies2() {
        return taxies2;
    }

    public String getHotels1() {
        return hotels1;
    }

    public String getHotels2() {
        return hotels2;
    }
}
