import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 10/04/2018.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost\\THANGPHAN\\SQLEXPRESS:1433;database=httt2k9";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("connection...");
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("driver name: " + dm.getDriverName());
                System.out.println("driver version: " + dm.getDriverName());
                System.out.println("product name: " + dm.getDatabaseProductName());
                System.out.println("driver version: " + dm.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
