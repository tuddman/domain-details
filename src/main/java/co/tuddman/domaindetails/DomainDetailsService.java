package co.tuddman.domaindetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DomainDetailsService implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DomainDetailsService.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {

		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS domain ( \n" +
				"   id UUID NOT NULL, \n" +
				"   url VARCHAR(100), \n" +
				"   details VARCHAR(2000) NOT NULL, \n" +
				"   notes VARCHAR(2000) NOT NULL, \n" +
				"   first_discovered DATE \n" +
				");");
	}

}