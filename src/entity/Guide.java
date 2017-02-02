package entity;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by omid on 1/3/2017.
 */
@Entity
@BatchSize(size = 2) //this means that we optimize lazy fetching for proxy collection and reduce the number of
public class Guide {  // select queries. When 1 proxy accessed 2 other proxy will be loaded in cache.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "staff_id", nullable = false)
    private String staffId;
    private String name;
    private Integer salary;
    @OneToMany(mappedBy = "guide",cascade={CascadeType.PERSIST, CascadeType.MERGE} /*//using for detached object fetch = FetchType.EAGER */)
    private Set<Student> students=new HashSet<Student>();
    //using eager fetch is not appropriate because student is the owner and the object is eagerlly fetch by default.
    // and assosiated objects are lazilly fetch by default. so we dont' need to define them as fetch=Fetch.Lazy
    @Version  //this annotation prevents to lost update
    private int version;
    public Guide() {
    }

    public Guide(String staffId, String name, Integer salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }

    public Set<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Guide [id=" + id + ", staffId=" + staffId + ", name=" + name
                + ", salary=" + salary + ", students=" + students + "]";
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
