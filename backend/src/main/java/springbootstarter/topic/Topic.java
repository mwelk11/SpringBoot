package springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import springbootstarter.course.Course;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy="topic")
    @JsonManagedReference
    private List<Course> courses;

    public Topic() {

    }

    public Topic(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<Course>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
