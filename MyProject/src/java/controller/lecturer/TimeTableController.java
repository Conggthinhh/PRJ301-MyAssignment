/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.lecturer;

import dal.LecturerDBContext;
import dal.SessionDBContext;
import dal.TimeSlotDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import model.Lecturer;
import model.Session;
import model.TimeSlot;
import util.DateTimeHelper;

/**
 *
 * @author Mr.Thinh
 */
public class TimeTableController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        processRequest(req, resp);
    } 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        int lid = Integer.parseInt(req.getParameter("lid"));
        String raw_from = req.getParameter("from");
        String raw_to = req.getParameter("to");
        java.sql.Date from = null;
        java.sql.Date to = null;
        if(raw_from == null || raw_from.length() ==0)
        {
            Date now = new Date();
            int ToW = DateTimeHelper.getDayofWeek(now);
            Date handle_from = DateTimeHelper.addDays(now, 2 - ToW);
            Date handle_to = DateTimeHelper.addDays(now, 8 - ToW);
            from = DateTimeHelper.toDateSql(handle_from);
            to = DateTimeHelper.toDateSql(handle_to);
        }
        else
        {
            from = java.sql.Date.valueOf(raw_from);
            to = java.sql.Date.valueOf(raw_to);
        }
        
        req.setAttribute("from", from);
        req.setAttribute("to", to);
        req.setAttribute("dates", DateTimeHelper.getDateList(from, to));
        
        TimeSlotDBContext slot = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = slot.list();
        req.setAttribute("slots", slots);
        
        SessionDBContext ses = new SessionDBContext();
        ArrayList<Session> sessions = ses.sieves(lid, from, to);
        req.setAttribute("sessions", sessions);
        
        LecturerDBContext lec = new LecturerDBContext();
        Lecturer lecturer = lec.get(lid);
        req.setAttribute("lecturer", lecturer);
       
        req.getRequestDispatcher("../view/lecturer/timetable.jsp").forward(req, resp);  
    } 
}