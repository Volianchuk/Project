package model;

public class Driver {
    private String firstName;
    private String lastName;
    private int age;
    private String car;

    public Driver(String firstName, String lastName, int age, String car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.car = car;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
