public class LopHoc {
    private int ID;
    private String tenLop;
    private String giaoVien;

    public LopHoc() {
        this.ID = ID;
        this.tenLop = tenLop;
        this.giaoVien = giaoVien;

    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }


    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    @Override
    public String toString() {
        return "LopHoc{" +
                "ID=" + ID +
                ", tenLop='" + tenLop + '\'' +
                ", giaoVien='" + giaoVien + '\'' +
                '}';
    }
}
