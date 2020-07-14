package servlet;


import controller.Utils;
import model.Racer;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.temporal.ValueRange;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateRacerServlet extends HttpServlet {

    private Map<Integer, Racer> racers;

    @Override
    public void init()  throws ServletException  {

        final Object racers = getServletContext().getAttribute("racers");

        if (racers == null || !(racers instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.racers = (ConcurrentHashMap<Integer, Racer>) racers;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final String age = req.getParameter("age");
        final String car_model = req.getParameter("car_Model");
        final String max_Speed = req.getParameter("max_Speed");

        final Racer racer = racers.get(Integer.parseInt(id));

        racer.setName(name);
        racer.setAge(Integer.valueOf(age));
        racer.setCar_Model(car_model);
        racer.setMax_Speed(Integer.valueOf(max_Speed));

        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");

        if (Utils.idIsInvalid(id, racers)) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        final Racer racer = racers.get(Integer.parseInt(id));
        req.setAttribute("racer", racer);

        req.getRequestDispatcher("/WEB-INF/update.jsp")
                .forward(req, resp);
    }
}

