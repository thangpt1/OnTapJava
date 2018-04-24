import java.io.File;
import java.sql.SQLOutput;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//---Kiểm tra thư mục------------------------------
//        File apath=new File("F:\\VCCrop\\ThucTap\\BaiTap");
//
//        // kiem tra đường dẫn có tồn tại không
//        System.out.println("Sự tồn tịa của đường dẫn:"+apath.exists());
//
//        if(apath.exists()){
//            // kiểm tra apath có phải là thư mục không
//            System.out.println("trại thái thư mục của đường dẫn:"+apath.isDirectory());
//
//            // Kiểm tra 'apath' là một đường dẫn ẩn hay không?
//            System.out.println("đường dẫn ẩn " + apath.isHidden());
//
//            // Tên đơn giản.
//            System.out.println("Simple Name: " + apath.getName());
//
//            // Đường dẫn tuyêt đối.
//            System.out.println("Đường dẫn tuyệt đối: " + apath.getAbsolutePath());
//
//            // Kiểm tra kích thước file (Theo đơn vị byte):
//            System.out.println("kích thước file: " + apath.length()+"MB");
//
//            // Thời điểm sửa lần cuối (mili giây)
//            long lastMofifyInMillis = apath.lastModified();
//            Date lastModifyDate = new Date(lastMofifyInMillis);
//
//            System.out.println("Last modify date: " + lastModifyDate);
//        }
//----Tạo thư mục mới------------------------------------------------------------------------------------------------------------------
//        File dir1 = new File("F:\\ThuMucMoi\\test1");
//
//        System.out.println("Pathname: " + dir1.getAbsolutePath());
//        System.out.println("Path Exists? " + dir1.exists());
//        System.out.println("Parent Path Exists? " + dir1.getParentFile().exists());
//
//        // Với mkdir(), thư mục chỉ được tạo ra nếu thư mục cha tồn tại.
//        boolean created = dir1.mkdir();
//
//        System.out.println("Directory created? " + created);
//
//        System.out.println("--------------------");

//        File dir2 = new File("F:\\ThuMucMoi\\ThuMucMoi");
//
//        System.out.println("Pathname: " + dir2.getAbsolutePath());
//        System.out.println("Exists? " + dir2.exists());
//
//        // Với mkdir(), thư mục được tạo ra nếu thư mục cha chưa tồn tại.
//        boolean created = dir2.mkdirs();
//
//        System.out.println("Directory created? " + created);

//---Liệt kê tất cả các thư mục gốc---------------------------------------------------------
//        File[] roots=File.listRoots();
//        for (File root: roots
//             ) {
//            System.out.println(root.getAbsolutePath());
//        }
//    }
//--liệt kê ra tất cả các tập tin và thư mục con trực tiếp của một thư mục---------------------------------------------------------

//        System.out.println("liffile :");
//        File dir=new File("F:\\");
//        // get file
//        File[] childer=dir.listFiles();
//        for (File file:childer
//             ) {
//            System.out.println(file.getAbsolutePath());
//        }
//        // get tên file;
//        System.out.println("\nlist file name");
//        String[] paths=dir.list();
//        for (String path:paths
//             ) {
//            System.out.println(path);
//        }
//----- lấy file có đuôi mở rọng txt
        File dir=new File("F:\\VCCrop\\ThucTap\\BaiTap");
        File[] txtFile=dir.listFiles(new TxtFileter());
        for (File file:txtFile
             ) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println(txtFile[0].getAbsolutePath());
    }
}
