package servlet;

import controller.Utils;


import controller.Utils;
import model.Racer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DeleteRacerServlet extends HttpServlet {
    private Map<Integer, Racer> racers;

    @Override
    public void init() throws ServletException {

        final Object racers = getServletContext().getAttribute("racers");

        if (racers == null || !(racers instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.racers = (ConcurrentHashMap<Integer, Racer>) racers;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Utils.idIsNumber(req)) {
            racers.remove(Integer.valueOf(req.getParameter("id")));
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
