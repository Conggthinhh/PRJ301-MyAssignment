package controller.lecturer;

import dal.ReportDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Session;

/**
 *
 * @author Mr.Thinh
 */
public class ReportController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int gid = Integer.parseInt(req.getParameter("gid"));

        ReportDBContext rptDB = new ReportDBContext();
        Session s = rptDB.get(gid);
        req.setAttribute("ses", s);

        ArrayList<Session> sessions = rptDB.report(gid);
        req.setAttribute("sessions", sessions);

        req.getRequestDispatcher("../view/lecturer/report.jsp").forward(req, resp);
    }
}
