package com.anycomp.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.anycomp.marketplace")
public class AnycompMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnycompMarketplaceApplication.class, args);
	}

}
