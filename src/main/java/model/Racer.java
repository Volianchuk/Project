package model;

import java.util.Objects;

public class Racer {
    private int id;

    private String name;

    private int age;

    private String car_Model;

    private int max_Speed;

    public Racer(int id, String name, int age, String car_Model, int max_Speed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.car_Model = car_Model;
        this.max_Speed = max_Speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCar_Model() {
        return car_Model;
    }

    public void setCar_Model(String car_Model) {
        this.car_Model = car_Model;
    }

    public int getMax_Speed() {
        return max_Speed;
    }

    public void setMax_Speed(int max_Speed) {
        this.max_Speed = max_Speed;
    }
}