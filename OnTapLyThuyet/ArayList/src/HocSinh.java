public class HocSinh {
    private String ten;
    private  int tuoi;

    public HocSinh(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public HocSinh(String ten) {
        this.ten = ten;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HocSinh){
            HocSinh hs=(HocSinh) obj;
            return  ten.equals(hs.ten);
        }
        return super.equals(obj);
    }
}
