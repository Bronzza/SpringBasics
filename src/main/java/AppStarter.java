import entities.computers.ModelOneLaptop;
import entities.computers.ModelOnePc;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log4j
public class AppStarter {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext("entities");
        context.registerShutdownHook();
        ModelOneLaptop firstLaptop = context.getBean(ModelOneLaptop.class);
        firstLaptop.compute();
        ModelOneLaptop secondLaptop = context.getBean(ModelOneLaptop.class);
        log.info(firstLaptop.equals(secondLaptop));

        ModelOnePc firstPc = context.getBean("modelOnePc", ModelOnePc.class);
        ModelOnePc secondPC = context.getBean("modelOnePc", ModelOnePc.class);
        firstPc.compute();
        log.info(firstPc.equals(secondPC));
    }
}
