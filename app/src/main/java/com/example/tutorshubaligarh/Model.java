package com.example.tutorshubaligarh;

public class Model {
    String name,qualification,city;

    public Model(String name, String qualification, String city) {
        this.name = name;
        this.qualification = qualification;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public String getCity() {
        return city;
    }
}
