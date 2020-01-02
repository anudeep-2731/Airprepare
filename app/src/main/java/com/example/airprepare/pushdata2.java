package com.example.airprepare;

public class pushdata2 {
    String cities;
    String restu1;
    String restu2;
    String places1;
    String places2;
    public pushdata2(){}
    public pushdata2(String cities,String restu1,String restu2){
        this.restu1=restu1;
        this.restu2=restu2;
        this.cities=cities;
    }
    public pushdata2(String places1,String places2){
        this.places1=places1;
        this.places2=places2;
    }

    public String getCities() {
        return cities;
    }

    public String getRestu1() {
        return restu1;
    }

    public String getRestu2() {
        return restu2;
    }

    public String getPlaces1() {
        return places1;
    }

    public String getPlaces2() {
        return places2;
    }
}
