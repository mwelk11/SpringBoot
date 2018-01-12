package springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(int id) {
        return topicRepository.findOne(id);
    }

    public void addOrUpdateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(int id) {
        topicRepository.delete(id);
    }

}
