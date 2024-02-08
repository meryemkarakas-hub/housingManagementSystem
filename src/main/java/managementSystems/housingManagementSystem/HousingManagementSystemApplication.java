package managementSystems.housingManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = "managementSystems.housingManagementSystem.application")
public class HousingManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousingManagementSystemApplication.class, args);
    }

}
