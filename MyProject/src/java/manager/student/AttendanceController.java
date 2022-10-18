/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager.student;

import dal.StudentDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author Mr Thinh
 */

public class AttendanceController extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDBContext db = new StudentDBContext();
        ArrayList<Student> list2 = db.list();
        req.setAttribute("students", list2);
        req.getRequestDispatcher("../view/student/checkattendance.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDBContext db = new StudentDBContext();
        ArrayList<Student> list = db.list();
        req.setAttribute("students", list);
        req.getRequestDispatcher("../view/student/attendance.jsp").forward(req, resp);
    }     
}