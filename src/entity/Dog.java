package entity;

import javax.persistence.Entity;

/**
 * Created by omid on 2/1/2017.
 */
@Entity
public class Dog  extends Animal{
    @Override
    public String makeNoise() {
        return "woof Woof...";
    }
}
