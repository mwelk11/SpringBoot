package springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springbootstarter.topic.Topic;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable int topicId) {
        return courseService.getAllCourses(topicId); 
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable int topicId) {
        course.setTopic(new Topic(topicId, ""));
        courseService.addOrUpdateCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable int topicId) {
        course.setTopic(new Topic(topicId, ""));
        courseService.addOrUpdateCourse(course);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}
