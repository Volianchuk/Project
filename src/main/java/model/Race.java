package model;

public class Race {
    private String City;
    private double length;
    private double circuit;
    private int numberOfCircles;

    public Race(String city, double circuit, int numberOfCircles) {
        City = city;
        this.circuit = circuit;
        this.numberOfCircles = numberOfCircles;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public double getCircuit() {
        return circuit;
    }

    public void setCircuit(double circuit) {
        this.circuit = circuit;
    }

    public int getNumberOfCircles() {
        return numberOfCircles;
    }

    public void setNumberOfCircles(int numberOfCircles) {
        this.numberOfCircles = numberOfCircles;
    }
    public void setLength(double circuit,int numberOfCircles, double length){
        this.length = circuit*numberOfCircles;
    }

    public double getLength() {
        return length;
    }

}
