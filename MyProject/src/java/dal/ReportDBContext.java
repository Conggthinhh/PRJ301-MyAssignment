/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attandance;
import model.Group;
import model.Lecturer;
import model.Room;
import model.Session;
import model.Student;
import model.Subject;
import model.TimeSlot;

/**
 *
 * @author Mr.Thinh
 */
public class ReportDBContext extends DBContext<Session>{
    @Override
    public void insert(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session get(int id) {
        try {
            String sql = "SELECT ses.sesid,ses.[index],ses.[date],ses.attanded\n"
                    + "	,g.gid,g.gname\n"
                    + "	,sub.subid,sub.subname\n"
                    + "	,l.lid,l.lname\n"
                    + "	,s.stdid,s.stdname, s.stdmember\n"
                    + "	,ISNULL(a.present,0) present, ISNULL(a.[description],'') [description]\n"
                    + "		FROM [Session] ses\n"
                    + "		INNER JOIN [Group] g ON g.gid = ses.gid\n"
                    + "		INNER JOIN [Subject] sub ON sub.subid = g.subid\n"
                    + "		INNER JOIN Lecturer l ON l.lid = ses.lid\n"
                    + "		INNER JOIN [Student_Group] sg ON sg.gid = g.gid\n"
                    + "		INNER JOIN [Student] s ON s.stdid = sg.stdid\n"
                    + "		LEFT JOIN Attandance a ON s.stdid = a.stdid AND ses.sesid = a.sesid\n"
                    + " WHERE g.gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Session s = null;
            while (rs.next()) {
                if (s == null) {
                    s = new Session();
                    s.setDate(rs.getDate("date"));
                    s.setIndex(rs.getInt("index"));
                    s.setAttanded(rs.getBoolean("attanded"));
                    
                    Group g = new Group();
                    g.setId(rs.getInt("gid"));
                    g.setName(rs.getString("gname"));
                    s.setGroup(g);

                    Subject sub = new Subject();
                    sub.setId(rs.getInt("subid"));
                    sub.setName(rs.getString("subname"));
                    g.setSubject(sub);

                    Lecturer l = new Lecturer();
                    l.setId(rs.getInt("lid"));
                    l.setName(rs.getString("lname"));
                    s.setLecturer(l);

                }
                //read student
                Student stu = new Student();
                stu.setId(rs.getInt("stdid"));
                stu.setName(rs.getString("stdname"));
                stu.setMember(rs.getString("stdmember"));
                //read attandance
                Attandance a = new Attandance();
                a.setStudent(stu);
                a.setSession(s);
                a.setPresent(rs.getBoolean("present"));
                a.setDescription(rs.getString("description"));
                s.getAtts().add(a);
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

     @Override
    public ArrayList<Session> list() {
        ArrayList<Session> ses = new ArrayList<>();
        try {
            String sql = "SELECT TOP(5) ses.[date]\n"
                    + "  FROM [Session] ses";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Session sl = new Session();
                sl.setDate(rs.getDate("date"));
                ses.add(sl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ses;   
    }
    
    
}