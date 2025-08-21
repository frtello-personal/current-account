package co.com.tgc.currentaccount;

import org.springframework.boot.SpringApplication;

public class TestCurrentaccountApplication {

	public static void main(String[] args) {
		SpringApplication.from(CurrentaccountApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
