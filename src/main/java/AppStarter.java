import entities.computers.ModelOneLaptop;
import entities.computers.ModelOnePc;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppStarter {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext("entities");
        context.registerShutdownHook();
        ModelOneLaptop firstLaptop = context.getBean(ModelOneLaptop.class);
        firstLaptop.compute();
        ModelOneLaptop secondLaptop = context.getBean(ModelOneLaptop.class);
        System.out.println(firstLaptop.equals(secondLaptop));

        ModelOnePc firstPc = (ModelOnePc) context.getBean("modelOnePc");
        ModelOnePc secondPC = (ModelOnePc) context.getBean("modelOnePc");
        firstPc.compute();
        System.out.println(firstPc.equals(secondPC));
    }
}
