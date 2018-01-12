package springbootstarter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import springbootstarter.course.Course;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable int courseId) {
        return lessonService.getAllLessons(courseId); 
    }

    @RequestMapping("topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getLesson(@PathVariable int id) {
        return lessonService.getLesson(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson lesson, 
            @PathVariable int topicId, @PathVariable int courseId) {
        lesson.setCourse(new Course(courseId, "", ""));
        lessonService.addOrUpdateLesson(lesson);
    }

    @RequestMapping(method=RequestMethod.PUT, value="topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable int topicId, 
            @PathVariable int courseId, @PathVariable int id) {
        lesson.setId(id);
        lesson.setCourse(new Course(courseId, "", ""));
        lessonService.addOrUpdateLesson(lesson);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void deleteLesson(@PathVariable int id) {
        lessonService.deleteLesson(id);
    }
}
