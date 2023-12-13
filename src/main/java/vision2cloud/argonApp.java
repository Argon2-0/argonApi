package vision2cloud;

import org.postgresql.util.PSQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages={"vision2cloud.argon"})
public class argonApp {
    public static void main(String[] args) throws PSQLException {
        try {
            SpringApplication.run(argonApp.class, args);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
