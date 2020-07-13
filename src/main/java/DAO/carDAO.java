package DAO;

import model.car;

import java.sql.SQLException;
import java.util.List;

public interface carDAO {
    void add(car car) throws SQLException;
    List<car> getAll () throws SQLException;
    car getById(Long Id) throws SQLException;
    void update(car car) throws SQLException;
    void remove(car car) throws SQLException;
}
