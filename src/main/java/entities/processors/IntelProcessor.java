package entities.processors;

import interfaces.Processor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Log4j
@Component("intel")
public class IntelProcessor implements Processor {
    public void process() {
        log.info("Intel processor start working...");
    }
}
