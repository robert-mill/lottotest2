package javasql;
import com.mysql.jdbc.Driver;
import java.sql.*;

/**
 *
 * @author rmill_000
 */
public class Connect {
    public Connect() throws SQLException{
        makeConnection();
    }
    
    private Connection konnect;
    
    public  Connection makeConnection() throws SQLException {
        if (konnect == null) {
             new Driver();
            // buat koneksi
             konnect = DriverManager.getConnection(
                       "jdbc:mysql://localhost/lottotest",
                       "root",
                       "");
         }
         return konnect;
     } 
    public static void main(String args[]) {
        System.out.println("Start");
         try {
             Connect c = new Connect();
             System.out.println("Connectionblished");
         }
         catch (SQLException e) {
             e.printStackTrace();
             System.err.println("Connectionure");
         }  

    }
    
}
