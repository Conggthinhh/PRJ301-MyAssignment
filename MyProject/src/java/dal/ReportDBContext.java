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
public class ReportDBContext extends DBContext<Session> {

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
            String sql = "SELECT ses.sesid, l.lid, g.gid, g.gname, s.stdid, s.stdmember, s.stdname, ses.date, a.present\n"
                    + "          FROM [Session] ses\n"
                    + "		  INNER JOIN [Group] g ON g.gid = ses.gid\n"
                    + "		  INNER JOIN [Student_Group] st ON st.gid = g.gid\n"
                    + "		  INNER JOIN [Student] s ON st.stdid = s.stdid\n"
                    + "		  INNER JOIN Lecturer l ON l.lid = ses.lid\n"
                    + "		  LEFT JOIN Attandance a ON s.stdid = a.stdid AND ses.sesid = a.sesid\n"
                    + "	 WHERE g.gid = ?";
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

                    Lecturer l = new Lecturer();
                    l.setId(rs.getInt("lid"));
                    s.setLecturer(l);

                    s.setDate(rs.getDate("date"));
                    s.setId(rs.getInt("sesid"));
                }
                Student stu = new Student();
                stu.setId(rs.getInt("stdid"));
                stu.setName(rs.getString("stdname"));
                stu.setMember(rs.getString("stdmember"));

                Attandance a = new Attandance();
                a.setStudent(stu);
                a.setSession(s);
                a.setPresent(rs.getBoolean("present"));
                s.getAtts().add(a);
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Session> report(int id) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "SELECT ses.sesid, l.lid, g.gid, g.gname, s.stdid, s.stdmember, s.stdname, ses.date, a.present\n"
                    + "           FROM [Session] ses\n"
                    + "		  INNER JOIN [Group] g ON g.gid = ses.gid\n"
                    + "		  INNER JOIN [Student_Group] st ON st.gid = g.gid\n"
                    + "		  INNER JOIN [Student] s ON st.stdid = s.stdid\n"
                    + "		  INNER JOIN Lecturer l ON l.lid = ses.lid\n"
                    + "		  LEFT JOIN Attandance a ON s.stdid = a.stdid AND ses.sesid = a.sesid\n"
                    + "  WHERE g.gid = ?";
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

                    Lecturer l = new Lecturer();
                    l.setId(rs.getInt("lid"));
                    s.setLecturer(l);

                    s.setDate(rs.getDate("date"));
                    s.setId(rs.getInt("sesid"));

                    Student stu = new Student();
                    stu.setId(rs.getInt("stdid"));
                    stu.setName(rs.getString("stdname"));
                    stu.setMember(rs.getString("stdmember"));

                    Attandance a = new Attandance();
                    a.setPresent(rs.getBoolean("present"));
                    a.setStudent(stu);
                    a.setSession(s);
                    s.getAtts().add(a);
                    sessions.add(s);
                }
            }
            return sessions;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Session> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
