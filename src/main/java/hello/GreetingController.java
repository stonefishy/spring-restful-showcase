package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Andrewsy on 2016/4/4.
 */
@RestController
public class GreetingController {
    private static final String TEMPLATE = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")
                             String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(TEMPLATE, name));
    }

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    public Greeting greeting2(@PathVariable(value = "name") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(TEMPLATE, name));
    }
}
