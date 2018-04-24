import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Student class
 *
 * @author viettuts.vn
 */
class Student {
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student@name=" + name + ",age=" + age + ",address=" + address;
    }
}

/**
 * HashSetExample2 class
 *
 * @author viettuts.vn
 */
public class Setobject {
    public static void main(String[] args) {
        // init set
        Set<Student> set = new HashSet<Student>();
        // create students object
        Student student1 = new Student("Cong", 17, "Hanoi");
        Student student2 = new Student("Dung", 16, "Haiphong");
        Student student3 = new Student("Ngon", 18, "Hanoi");
        Student student4 = new Student("Hanh", 19, "Danang");
        // add students object to set
        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);
        set.add(student1);
        // show set
        Iterator<Student> iterator = set.iterator();
        Student student;
        while (iterator.hasNext()) {
            student = iterator.next();
            System.out.println(student.toString());
        }
    }
}
