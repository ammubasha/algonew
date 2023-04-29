package com.algo.batch;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {
	
	

	    @Autowired
	    private DataSource dataSource;

	    @Bean(initMethod = "migrate")
	    public Flyway flyway() {
	    //	Location location = new Location("classpath:db/flyweb,classpath:db/flyweb,classpath:db/flyweb");
	        Flyway flyway = Flyway.configure()
	                .dataSource(dataSource)
	            //  .locations(locations)    
	                .baselineOnMigrate(true).load();
	        
	        MigrateResult result = flyway.migrate();
	           
	        return flyway;
	    }

}
