package back2basics.logbackasynctest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class ApiController {

    @GetMapping("/api")
    public String index() {
        log.info("hi ~~~~~~");
        return "OK";
    }
}