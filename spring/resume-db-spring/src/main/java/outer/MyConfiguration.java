package outer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Scope("prototype")
public class MyConfiguration {

    @Bean("obj")
    public Object getObject() {
        System.out.println("My object was created");
        return new Object();
    }
    public MyConfiguration() {
        System.out.println("My configuration was created");
    }
}