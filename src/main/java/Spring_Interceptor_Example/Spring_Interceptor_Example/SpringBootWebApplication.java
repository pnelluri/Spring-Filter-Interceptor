package Spring_Interceptor_Example.Spring_Interceptor_Example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
@SpringBootApplication
@ComponentScan("com.nisum.*")
public class SpringBootWebApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	
}