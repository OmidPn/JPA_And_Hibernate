package entity;

import javax.persistence.*;

/**
 * Created by omid on 2/1/2017.
 */
@Entity
//@Inheritance(strategy= InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.JOINED) // to be used when you want to test JOINED strategy for inheritance mapping
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
// to be used when you want to test TABLE_PER_CLASS (Table per concrete class) strategy for inheritance mapping
public abstract class Animal {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.TABLE) //when the inheritance is TABLE_PER_CLASS
    Long id;
   // @Column(nullable = false)  //cannot be used nullable when using SINGLE_TABLE strategy
    String name;

    public void setName(String name) {
        this.name = name;
    }
    public abstract String makeNoise();

    @Override
    public String toString() {
        return name +" making "+ makeNoise()+" noise.";}
}
