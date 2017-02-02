package entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
/**
 * Created by omid on 1/3/2017.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long st_id;
    @Column(name="enrollment_id", nullable=false)
    private String enrollmentId;

    private String name;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="guide_id")
    private Guide guide;

    public Student() {}
    public Student(String enrollmentId, String name, Guide guide) {
        this.enrollmentId = enrollmentId;
        this.name = name;
        this.guide = guide;
    }

    public Student(String enrollmentId, String name) {
        this.enrollmentId = enrollmentId;
        this.name = name;
    }

    //implement equals and hashCode for Student to not accept same object
    @Override
    public int hashCode(){
        return new HashCodeBuilder().append(enrollmentId).toHashCode();
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Student)) return  false;
        Student other=(Student) obj;
        return new EqualsBuilder().append(enrollmentId,other.enrollmentId).isEquals();
    }

    @Override
    public String toString() {
        return "Student [id=" + st_id + ", enrollmentId=" + enrollmentId
                + ", name=" + name + ", guide=" + guide + "]";
    }

    public Guide getGuide() {
        return guide;
    }

    public String getName() {
        return name;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public long getId() {
        return st_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
