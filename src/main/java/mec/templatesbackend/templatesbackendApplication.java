package mec.templatesbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.annotation.Bean;


import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@EntityScan ( basePackages= "mec.templatesbackend.model" )
@SpringBootApplication
public class templatesbackendApplication {

	public static void main (String[] args) {SpringApplication.run(templatesbackendApplication.class, args);}


	}

