package springbootstarter.greeting;

import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class GreetingService {

    private final AtomicLong counter = new AtomicLong();

    private List<Greeting> greetings = new ArrayList<>(Arrays.asList(
        new Greeting(counter.incrementAndGet(), "World"),
        new Greeting(counter.incrementAndGet(), "Matt"),
        new Greeting(counter.incrementAndGet(), "hahahahaha")
    ));

    public List<Greeting> getAllGreetings() {
        return greetings;
    }

    public Greeting getGreeting(String name) {
        return greetings.stream().filter(t -> t.getName().equals(name)).findFirst().get();
    }

    public void addGreeting(Greeting greeting) {
        greetings.add(greeting);
    }

}
