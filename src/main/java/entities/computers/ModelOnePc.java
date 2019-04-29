package entities.computers;

import interfaces.Computer;
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

@Getter
@Setter
@Log4j
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PropertySource({"classpath:modelOnePc.properties"})
public class ModelOnePc implements Computer {
    @Autowired
    @Qualifier("amd")
    protected Processor processor;

    @Value("${size2}")
    private int size;

    public void compute() {
        log.info("Computer " + this.getClass().getSimpleName() + " is turned on. Its size is= " + size);
        processor.process();
    }
}
