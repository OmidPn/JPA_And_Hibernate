package entity;

import javax.persistence.*;

/**
 * Created by omid on 1/3/2017.
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Costumenr_name")
    private String name;
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="passport_id",unique = true)
    private Passport passport;

    public Customer() {
    }

    public Customer(String name, Passport passport) {
        this.id = id;
        this.name = name;
        this.passport = passport;
    }

    public Passport getPassport() {
        return passport;
    }
}
