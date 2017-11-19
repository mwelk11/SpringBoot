package springbootstarter.greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping("/greetings/{name}")
    public Greeting greeting(@PathVariable String name) {
        return greetingService.getGreeting(name);
    }

    @RequestMapping("/greetings")
    public List<Greeting> greeting() {
        return greetingService.getAllGreetings(); 
    }

    @RequestMapping(method=RequestMethod.POST, value="/greetings")
    public void addGreeting(@RequestBody Greeting greeting) {
        greeting.setContent();
        greetingService.addGreeting(greeting);
    }

}
