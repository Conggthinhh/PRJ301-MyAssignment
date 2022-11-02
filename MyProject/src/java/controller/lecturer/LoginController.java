/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.lecturer;

import dal.LoginDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Lecturer;
import model.Lecturer_Login;
import model.Session;

/**
 *
 * @author Mr,Thinh
 */
public class LoginController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("../view/lecturer/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("loid"));
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        LoginDBContext db = new LoginDBContext();
        Lecturer_Login lecturer = db.get(id, user, pass);
        if(lecturer!=null)
        {
            req.getSession().setAttribute("lecturer", lecturer);
            resp.sendRedirect("timetable?lid=" + lecturer.getId());
        }
        else
        {
            resp.getWriter().println("Incorrect password or password. Try again!");
        }
    }   
    

}