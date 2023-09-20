package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Data {
    public static Connection getconnection() {
    Connection c = null;
    try {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String url = "jdbc:mysql://localhost:3306/qltv?useSSL=false";
        String username = "root";
        String password = "";
        // Tạo kết nối
        c = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return c;
}

  
    public static void closeconection(Connection c)
    {
        try {
            if(c!=null)
            {
                c.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
