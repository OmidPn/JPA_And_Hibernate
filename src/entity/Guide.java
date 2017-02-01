package entity;

import javax.persistence.*;

/**
 * Created by omid on 1/3/2017.
 */
@Entity
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "staff_id", nullable = false)
    private String staffId;
    private String name;
    private Integer salary;

    public Guide() {
    }

    public Guide(String staffId, String name, Integer salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }
}
