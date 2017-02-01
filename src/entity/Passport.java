package entity;

import javax.persistence.*;

/**
 * Created by omid on 1/3/2017.
 */
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name="passport_number")
    private String passport_Number;
    @OneToOne(mappedBy = "passport")
    private Customer customer;

    public Passport() {
    }

    public Passport( String passport_Number) {
        this.passport_Number = passport_Number;
    }

    public Customer getCustomer() {
        return customer;
    }
}
