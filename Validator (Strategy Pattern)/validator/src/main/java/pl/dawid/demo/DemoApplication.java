package pl.dawid.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import pl.dawid.service.UserService;

@ComponentScan({ "pl.dawid.*" })
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	UserService userService;

	public DemoApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// userService.createUser(new User(UserType.USER,"Stefan", "stefp"));
		// userService.createUser(new User(UserType.USER,"Dawid", "dawid@wp.pl"));
		// userService.createUser(new User(UserType.USER,"Tomek", "tomek.pl"));
		// userService.createUser(new User(UserType.MANAGER,"Roman", "Romanwp.pl"));
		// userService.createUser(new User(UserType.MANAGER,"Zbyszek",
		// "zbyszek@manager.com"));
	}

}
