package controller;



import model.Racer;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Utils {public static boolean idIsNumber(HttpServletRequest request) {
    final String id = request.getParameter("id");
    return id != null &&
            (id.length() > 0) &&
            id.matches("[+]?\\d+");
}

    public static boolean requestIsValid(HttpServletRequest request) {
        final String name = request.getParameter("name");
        final String age = request.getParameter("age");
        final String car_Model = request.getParameter("car_Model");
        final String max_Speed = request.getParameter("max_Speed");

        return name != null && name.length() > 0 &&
                age != null && age.length() > 0 &&
                age.matches("[+]?\\d+");
    }

    public static Racer createStubRacer(final int id,
                                        final String name,
                                        final int age,
                                        final String car_Model,
                                        final int max_Speed) {
        Racer racer = new Racer(id,name,age,car_Model,max_Speed);
        return racer;
    }

    public static boolean idIsInvalid(final String id, Map<Integer, Racer> repo) {
        return !(id != null &&
                id.matches("[+]?\\d+") &&
                repo.get(Integer.parseInt(id)) != null);
    }
}
