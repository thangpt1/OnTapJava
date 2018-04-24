import java.sql.*;
import java.sql.Connection;
import java.util.List;

public class Main {
    private PreparedStatement pstm = null;
    private static ResultSet rs;
    private static Connection conn;
    private static String a;

    public static void main(String[] args) {
        Connection1 con=new Connection1();
        if(con.ketNoi()){
          con.insert("Hoa");
            List<LopHoc> lopHocs=con.select();
            for (LopHoc lh:lopHocs
                    ) {
                System.out.println(lh);
            }
        }

    }





}
