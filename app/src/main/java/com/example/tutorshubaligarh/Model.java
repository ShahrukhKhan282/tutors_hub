package com.example.tutorshubaligarh;

public class Model {
    String name,qualification,city,experience,classes,phone;

    public Model(String name, String qualification, String city, String experience, String classes, String phone) {
        this.name = name;
        this.qualification = qualification;
        this.city = city;
        this.experience = experience;
        this.classes = classes;
        this.phone = phone;
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

    public String getExperience() {
        return experience;
    }

    public String getClasses() {
        return classes;
    }

    public String getPhone() {
        return phone;
    }
}
