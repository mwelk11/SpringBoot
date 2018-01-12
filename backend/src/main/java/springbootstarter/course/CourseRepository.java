package springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    public List<Course> findByTopicId(int topicId);

}
