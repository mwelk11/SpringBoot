package springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
