package servlet;



import controller.Utils;
import model.Racer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextListener implements ServletContextListener {

    private Map<Integer, Racer> racers;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        racers = new ConcurrentHashMap<>();

        servletContext.setAttribute("racers", racers);

        final Racer racer = Utils.createStubRacer(1,"Oleh", 23, "Reno", 200);
        this.racers.put(racer.getId(), racer);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Close recourse.
        racers = null;
    }
}
