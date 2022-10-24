/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
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
 * @author ADMIN
 */
public class SessionDBContext extends dal.DBContext<Session> {

    @Override
    public void insert(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session model) {
        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE [Session]\n"
                    + "   SET attanded = 1\n"
                    + " WHERE sesid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getId());
            stm.executeUpdate();

            sql = "DELETE [Attandance]\n"
                    + " WHERE sesid = ?";
            PreparedStatement stm_remove_available = connection.prepareStatement(sql);
            stm_remove_available.setInt(1, model.getId());
            stm_remove_available.executeUpdate();
            
            for(Attandance a : model.getAtts()){
                 sql = "INSERT INTO [Attandance]\n"
                        + "           ([sesid]\n"
                        + "           ,[stdid]\n"
                        + "           ,[present]\n"
                        + "           ,[description]\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n";
                PreparedStatement stm_insert_new_record = connection.prepareStatement(sql);
                stm_insert_new_record.setInt(1, model.getId());
                stm_insert_new_record.setInt(2, a.getStudent().getId());
                stm_insert_new_record.setBoolean(3, a.isPresent());
                stm_insert_new_record.setString(4, a.getDescription());
                stm_insert_new_record.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public Session get(int id) {
        try {
            String sql = "SELECT ses.sesid,ses.[index],ses.date,ses.attanded\n"
                    + "	,g.gid,g.gname\n"
                    + "	,sub.subid,sub.subname\n"
                    + "	,r.rid,r.rname\n"
                    + "	,t.tid,t.[description] tdescription\n"
                    + "	,l.lid,l.lname\n"
                    + "	,s.stdid,s.stdname, s.stdmember\n"
                    + "	,ISNULL(a.present,0) present, ISNULL(a.[description],'') [description]\n"
                    + "		FROM [Session] ses\n"
                    + "		INNER JOIN [Group] g ON g.gid = ses.gid\n"
                    + "		INNER JOIN [Subject] sub ON sub.subid = g.subid\n"
                    + "		INNER JOIN Room r ON r.rid = ses.rid\n"
                    + "		INNER JOIN TimeSlot t ON t.tid = ses.tid\n"
                    + "		INNER JOIN Lecturer l ON l.lid = ses.lid\n"
                    + "		INNER JOIN [Student_Group] sg ON sg.gid = g.gid\n"
                    + "		INNER JOIN [Student] s ON s.stdid = sg.stdid\n"
                    + "		LEFT JOIN Attandance a ON s.stdid = a.stdid AND ses.sesid = a.sesid\n"
                    + " WHERE ses.sesid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Session s = null;
            while (rs.next()) {
                if (s == null) {
                    s = new Session();
                    Group g = new Group();
                    g.setId(rs.getInt("gid"));
                    g.setName(rs.getString("gname"));
                    s.setGroup(g);

                    Subject sub = new Subject();
                    sub.setId(rs.getInt("subid"));
                    sub.setName(rs.getString("subname"));
                    g.setSubject(sub);

                    Room r = new Room();
                    r.setId(rs.getInt("rid"));
                    r.setName(rs.getString("rname"));
                    s.setRoom(r);

                    TimeSlot t = new TimeSlot();
                    t.setId(rs.getInt("tid"));
                    t.setDescription(rs.getString("tdescription"));
                    s.setTimeslot(t);

                    Lecturer l = new Lecturer();
                    l.setId(rs.getInt("lid"));
                    l.setName(rs.getString("lname"));
                    s.setLecturer(l);

                    s.setDate(rs.getDate("date"));
                    s.setIndex(rs.getInt("index"));
                    s.setAttanded(rs.getBoolean("attanded"));
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Session> sieves(int lid, Date from, Date to) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "	ses.sesid,ses.[date],ses.[index],ses.attanded\n"
                    + "	,g.gid,g.gname\n"
                    + "	,sub.subid,sub.subname\n"
                    + "	,l.lid,l.lname\n"
                    + "	,r.rid,r.rname\n"
                    + "	,t.tid,t.[description]\n"
                    + " FROM [Session] ses \n"
                    + "			INNER JOIN [Group] g ON g.gid = ses.gid\n"
                    + "			INNER JOIN [Subject] sub ON sub.subid = g.subid\n"
                    + "			INNER JOIN Lecturer l ON l.lid = ses.lid\n"
                    + "			INNER JOIN Room r ON r.rid = ses.rid\n"
                    + "			INNER JOIN TimeSlot t ON t.tid = ses.tid\n"
                    + " WHERE\n"
                    + " l.lid = ?\n"
                    + " AND ses.[date] >= ?\n"
                    + " AND ses.[date] <= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, lid);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                Group g = new Group();
                Room r = new Room();
                Lecturer l = new Lecturer();
                TimeSlot t = new TimeSlot();
                Subject sub = new Subject();

                s.setId(rs.getInt("sesid"));
                s.setDate(rs.getDate("date"));
                s.setIndex(rs.getInt("index"));
                s.setAttanded(rs.getBoolean("attanded"));

                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                s.setGroup(g);

                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                g.setSubject(sub);

                l.setId(rs.getInt("lid"));
                l.setName(rs.getString("lname"));
                s.setLecturer(l);

                r.setId(rs.getInt("rid"));
                r.setName(rs.getString("rname"));
                s.setRoom(r);

                t.setId(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
                s.setTimeslot(t);

                sessions.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

}