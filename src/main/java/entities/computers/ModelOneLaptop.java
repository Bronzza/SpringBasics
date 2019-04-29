package entities.computers;

import interfaces.Computer;
import interfaces.Monitor;
import interfaces.Processor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Setter
@Log4j
@Component
@PropertySource({"classpath:OneLaptop.properties"})
@AllArgsConstructor
@NoArgsConstructor
public class ModelOneLaptop implements Computer {

    protected Processor processor;
    protected Monitor monitor;

    @Value("${size1}")
    private int size;

    @Autowired
    public ModelOneLaptop(@Qualifier("intel") Processor processor, @Qualifier("samsung") Monitor monitor) {
        this.processor = processor;
        this.monitor = monitor;
    }

    public void compute() {
        log.info("Computer " + this.getClass().getSimpleName() + " is turned on. Its size is= " + this.size);
        processor.process();
        monitor.display();
    }

    @PostConstruct
    private void init() {
        log.info("Plaging our cables, starting soon");
    }

    @PreDestroy
    private void preDestroy() {
        log.info("We are about to be turned off");
    }
}
