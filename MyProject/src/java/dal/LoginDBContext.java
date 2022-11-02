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
import model.Lecturer;
import model.Lecturer_Login;

/**
 *
 * @author Mr.Thinh
 */
public class LoginDBContext extends DBContext<Lecturer_Login> {

    @Override
    public void insert(Lecturer_Login model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lecturer_Login model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lecturer_Login model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lecturer_Login get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Lecturer_Login> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Lecturer_Login get(int id, String username, String password) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT l.lid, l.lname,\n"
                    + "		 ln.loid, ln.username, ln.[password]\n"
                    + "   FROM Lecturer l\n"
                    + "          LEFT JOIN Lecturer_Login lo ON lo.loid = l.lid\n"
                    + "	         LEFT JOIN [Login] ln ON lo.loid = ln.loid\n"
                    + "	  WHERE ln.loid = ? AND ln.username = ? AND ln.[password] = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, username);
            stm.setString(3, password);
            rs = stm.executeQuery();
            Lecturer_Login lecturer_lo = null;
            while (rs.next()) {
                if (lecturer_lo == null) {
                    lecturer_lo = new Lecturer_Login();
                    lecturer_lo.setId(id);
                    lecturer_lo.setUsername(username);
                }
            }         
            return lecturer_lo;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (stm != null)
                try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connection != null)
                try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}