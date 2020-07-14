package servlet;

import model.Racer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GetIndexPageServlet extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("racers",racers.values());
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
