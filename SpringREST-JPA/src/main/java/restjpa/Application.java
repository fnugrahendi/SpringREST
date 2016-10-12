package restjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by SRIN on 10/12/2016.
 */

@SpringBootApplication
@EntityScan(basePackages = {"restjpa/model"})
@EnableJpaRepositories(basePackages = {
        "restjpa.repo"
})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
