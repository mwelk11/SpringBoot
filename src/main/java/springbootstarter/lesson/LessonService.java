package springbootstarter.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(int courseId) {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findByCourseId(courseId).forEach(lessons::add);
        return lessons;
    }

    public Lesson getLesson(int id) {
        return lessonRepository.findOne(id);
    }

    public void addOrUpdateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteLesson(int id) {
        lessonRepository.delete(id);
    }

}
