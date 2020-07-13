package controller;

import model.car;
import model.Driver;
import model.car;

import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(urlPatterns = "/HelloJava",description = "", displayName="")
public class HelloJava extends HttpServlet {
    private String url = "jdbc:h2:~test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:DB.sql'";
    private final static String index = "index.jsp";
    private List<car> cars;
    private static Statement stmt;
    private static ResultSet rs;


   /* public void connection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM car WHERE id=(?) ");
        ){
            statement.setInt(1,1);
            rs =statement.executeQuery();

            if (rs.next()){
                String byName = "model:"+rs.getString("model");
                System.out.println(byName);
            }
        } finally {

        }
    }*/

    @Override
    public void init() throws ServletException {
        cars = new CopyOnWriteArrayList<>();
        cars.add(new car(1,"Audi",222,333,3,67));
        cars.add(new car(2,"KIA", 240, 430, 7.9, 895));
        //car car1 = new car(3,"Lanos",200, 200, 20, 1000);
    }

    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
       /* req.setAttribute("car", cars);
        req.getRequestDispatcher(index).forward(req,res);*/
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        //res.setContentType("index.jsp; charset=UTF-8");

        PrintWriter printWriter = res.getWriter();
        //printWriter.println("firstName:"+firstName+" "+ "lastName:"+" "+lastName);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        if( !requestIsValid(req)){
            doGet(req,res);
        }
        final String id = req.getParameter("id");
        final String model = req.getParameter("model");
        final String max_Speed = req.getParameter("max_Speed");
        final String engine_Power = req.getParameter("engine_Power");
        final String time_to_100 = req.getParameter("time_to_100");
        final String weight = req.getParameter("weight");

        final car car = new car(Integer.valueOf(id),model,Integer.valueOf(max_Speed),Integer.valueOf(engine_Power),Double.valueOf(time_to_100),Double.valueOf(weight));

        cars.add(car);

        doGet(req, res);
        res.setContentType("index.jsp; charset=UTF-8");

        PrintWriter printWriter = res.getWriter();
        printWriter.println("id:"+id+" model:"+model+" max_Speed:"+max_Speed+" engine_Power:"+engine_Power+" time_to_100:"+time_to_100+" weight:"+weight);

    }

    private boolean requestIsValid(final  HttpServletRequest req){

        final String id = req.getParameter("id");
        final String model = req.getParameter("model");
        final String max_Speed = req.getParameter("max_Speed");
        final String engine_Power = req.getParameter("engine_Power");
        final String time_to_100 = req.getParameter("time_to_100");
        final String weight = req.getParameter("weight");

        return id != null && id.length()>0 &&
                model != null && model.length()>0 &&
                max_Speed != null && max_Speed.matches("[+]?\\d+") &&
                engine_Power != null && engine_Power.matches("[+]?\\d+") &&
                time_to_100 != null && time_to_100.matches("[+]?\\d+") &&
                weight != null && weight.matches("[+]?\\d+");
    }

    @Override
    public void destroy(){

    }

}
