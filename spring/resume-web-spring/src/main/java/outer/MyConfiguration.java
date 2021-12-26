package outer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Scope("prototype")
@Slf4j
public class MyConfiguration {

    @Bean("obj")
    public Object getObject() {
        log.info("My object was created");
        return new Object();
    }
    public MyConfiguration() {
        log.info("My configuration was created");
    }
}