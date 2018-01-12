package springbootstarter.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {

    public List<Lesson> findByCourseId(int courseId);

}
