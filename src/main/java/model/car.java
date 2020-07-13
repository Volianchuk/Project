package model;

import java.util.Objects;

public class car {
    private int id;
    private String model;
    private int max_Speed;
    private int engine_Power;
    private double time_to_100;
    private double weight;

    public car(int id,String model,int max_Speed, int engine_Power, double time_to_100, double weight) {
        this.id=id;
        this.model=model;
        this.max_Speed=max_Speed;
        this.engine_Power=engine_Power;
        this.time_to_100=time_to_100;
        this.weight=weight;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMax_Speed() {
        return max_Speed;
    }

    public void setMax_Speed(int max_Speed) {
        this.max_Speed = max_Speed;
    }

    public int getEngine_Power() {
        return engine_Power;
    }

    public void setEngine_Power(int engine_Power) {
        this.engine_Power = engine_Power;
    }

    public double getTime_to_100() {
        return time_to_100;
    }

    public void setTime_to_100(double time_to_100) {
        this.time_to_100 = time_to_100;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        car car = (car) o;
        return id == car.id &&
                max_Speed == car.max_Speed &&
                engine_Power == car.engine_Power &&
                Double.compare(car.time_to_100, time_to_100) == 0 &&
                Double.compare(car.weight, weight) == 0 &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, max_Speed, engine_Power, time_to_100, weight);
    }

    @Override
    public String  toString() {
        return "Car{" +
                "Id=" + id +
                ", model='" + model + '\'' +
                ", max_Speed=" + max_Speed +
                ", engine_Power=" + engine_Power +
                ", time_to_100=" + time_to_100 +
                ", weight=" + weight +
                '}';
    }
}
