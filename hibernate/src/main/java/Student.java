import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int Id;


    @Column(name="name")
    private String name;

    @Column(name="mark")
    private int mark;

    public Student() {
    }

    public Student(int id, String name, int mark) {
        Id = id;
        this.name = name;
        this.mark = mark;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
