import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class Connection1 {
    private  PreparedStatement pstm=null;
    private  ResultSet rs;
    private java.sql.Connection conn;

    public boolean ketNoi(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost\\THANGPHAN\\SQLEXPRESS:1433;database=httt2k9;integratedSecurity=true;";
            conn = (java.sql.Connection) DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("connection...");
//                DatabaseMetaData dm = conn.getMetaData();
//                System.out.println("driver name: " + dm.getDriverName());
//                System.out.println("driver version: " + dm.getDriverName());
//                System.out.println("product name: " + dm.getDatabaseProductName());
//                System.out.println("driver version: " + dm.getDatabaseProductVersion());
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            System.out.println("day la finally");
        }
        return false;
    }

    public  List<LopHoc> select() {
        List<LopHoc> lopHocs = new ArrayList<>();

        try {
            String sql = "SELECT * FROM lophoc";//where malop=? and MatKhau=? and VaiTro='Admin'";
            pstm = conn.prepareStatement(sql);
//            pstm.setString(1,id);
//            pstm.setString(2,pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                LopHoc lopHoc = new LopHoc();
                lopHoc.setID(rs.getInt("malop"));
                lopHoc.setTenLop(rs.getString("tenlop"));
                lopHoc.setGiaoVien(rs.getString("gv"));
                lopHocs.add(lopHoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lopHocs;
    }
    public void insert(String tenLop){
        try {
            String sql="INSERT INTO lophoc(tenlop,gv) VALUES(?,N'Tiếng Việt')";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,tenLop);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
