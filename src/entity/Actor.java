package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by omid on 1/3/2017.
 */
@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Actor_name")
    private String name;
    @ManyToMany(mappedBy = "actorSet")
    private Set<Movie> movieSet=new HashSet<Movie>();

    public Actor() {
    }

    public Actor(String name) {
        this.name=name;
    }
    public Set<Movie> getMovieSet(){
        return movieSet;
    }
}
