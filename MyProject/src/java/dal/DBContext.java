package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr.Thinh
 */
public abstract class DBContext<T> {

    protected Connection connection;

    public DBContext() {
        try {
            String username = "Thinh";
            String password = "29112002";
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=ASSIGNMENT";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //INSERT INTO
    public abstract void insert(T model);
    //UPDATE SET

    public abstract void update(T model);
    //DELETE FROM

    public abstract void delete(T model);
    //SELECT * FROM WHERE id =

    public abstract T get(int id);

    //SELECT * FROM
    public abstract ArrayList<T> list();
}
