package managementSystems.housingManagementSystem;

import managementSystems.housingManagementSystem.application.core.configuration.MailConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = "managementSystems.housingManagementSystem.application")
@Import(MailConfig.class)
public class HousingManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousingManagementSystemApplication.class, args);
    }

}
