package entities.monitors;

import interfaces.Monitor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Log4j
@Component("sony")
public class SonyMonitor implements Monitor {
    public void display() {
        log.info("Sony monitor displays");
    }
}
