import java.util.ArrayList;
import java.util.List;

public class User {
    private int user;
    private float per_user,user_old_time;
    private List<Source> source;

    @Override
    public String toString() {
        return "User{" +
                "user=" + user +
                ", per_user=" + per_user +
                ", user_old_time=" + user_old_time +
                ", source=" + source +
                '}';
    }

    public User() {
        source = new ArrayList<Source>();
    }


    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public float getPer_user() {
        return per_user;
    }

    public void setPer_user(float per_user) {
        this.per_user = per_user;
    }

    public float getUser_old_time() {
        return user_old_time;
    }

    public void setUser_old_time(float user_old_time) {
        this.user_old_time = user_old_time;
    }

    public List<Source> getSource() {
        return source;
    }

    public void setSource(List<Source> source) {
        this.source = source;
    }

//    public User(int user, float per_user, float user_old_time, List<Source> source) {
//        this.user = user;
//        this.per_user = per_user;
//        this.user_old_time = user_old_time;
//        this.source = source;
//    }
}
