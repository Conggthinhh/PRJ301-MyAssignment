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
import model.Student;

/**
 *
 * @author Mr Thinh
 */
public class StudentDBContext extends DBContext{
    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.[stid], s.[stmember], s.[stsurname], s.[stmiddlename], s.[stgivenname] FROM Student s";    
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                String stid = rs.getString("stid");
                String stmember = rs.getString("stmember");
                String stsurname  = rs.getString("stsurname");
                String stmiddlename  = rs.getString("stmiddlename");
                String stgivenname  = rs.getString("stgivenname");
                s.setStid(stid);
                s.setStmember(stmember);
                s.setStsurname(stsurname);
                s.setStmiddlename(stmiddlename);
                s.setStgivenname(stgivenname);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    public ArrayList<Student> list2() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.[stid], s.[stmember] FROM Student s";    
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                String stid = rs.getString("stid");
                String stmember = rs.getString("stmember");
                s.setStid(stid);
                s.setStmember(stmember);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
}