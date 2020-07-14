package servlet;

import model.Racer;
import controller.Utils;


import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class AddRacerServlet extends HttpServlet {
    private Map<Integer, Racer> racers;

    private AtomicInteger id;

    @Override
    public void init() throws ServletException {

        final Object racers = getServletContext().getAttribute("racers");

        if (racers == null || !(racers instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.racers = (ConcurrentHashMap<Integer, Racer>) racers;
        }

        id = new AtomicInteger(2);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (controller.Utils.requestIsValid(req)) {

            final String name = req.getParameter("name");
            final String age = req.getParameter("age");
            final String car_Model = req.getParameter("car_Model");
            final String max_Speed = req.getParameter("max_Speed");

            final int id = this.id.getAndIncrement();

            final Racer racer = new Racer(id, name,Integer.valueOf(age),car_Model,Integer.valueOf(max_Speed));

            racers.put(id, racer);
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
