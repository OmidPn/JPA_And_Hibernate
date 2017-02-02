package entity;

import javax.persistence.Entity;

/**
 * Created by omid on 2/1/2017.
 */
@Entity
public class Cat extends Animal {
    @Override
    public String makeNoise() {
        return "Meow Meow ....";
    }
}
