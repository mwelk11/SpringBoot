package springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import springbootstarter.topic.Topic;
import springbootstarter.lesson.Lesson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="topicId")
    @JsonBackReference
    private Topic topic;

    @OneToMany(mappedBy="course")
    @JsonManagedReference
    private List<Lesson> lessons;

    public Course() {

    }

    public Course(int id, String name, String description, int topicId) {
        this(id, name, description);
        this.topic = new Topic(topicId, "");
    }

    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lessons = new ArrayList<Lesson>();
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
