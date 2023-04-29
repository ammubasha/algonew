package com.algo.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component

public class JobCompletionNotificationListener implements JobExecutionListener {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");
			Object[] param = new Object[] {"RAJINI"};
			/*jdbcTemplate.query("SELECT first_name, last_name FROM people",
				(rs, row) -> new Person(
					rs.getString(1),
					rs.getString(2))
			).forEach(person -> log.info("Found <{{}}> in the database.", person));*/
			/*jdbcTemplate.queryForObject("SELECT first_name, last_name FROM people where first_name=?", 
					param, (rs,num)-> lastname=rs.getNString("last_name"));*/
			//deprecated method
			Person user =(Person) jdbcTemplate.queryForObject("SELECT first_name, last_name FROM people where first_name=?", param, (rs, rowNum) -> {
				Person userObj = new Person();
			    userObj.setFirstName(rs.getString("first_name"));
			    userObj.setLastName(rs.getString("last_name"));
			    return userObj;
			});
			log.info("User Returned:"+user.getFirstName()+"::"+user.getLastName());
			
			Person user1 =(Person) jdbcTemplate.queryForObject("SELECT first_name, last_name FROM people where first_name=?", (rs, rowNum) -> {
				Person userObj = new Person();
			    userObj.setFirstName(rs.getString("first_name"));
			    userObj.setLastName(rs.getString("last_name"));
			    return userObj;
			},param);
			log.info("User Returned for non deprecated:"+user1.getFirstName()+"::"+user1.getLastName());
			
			
		}
	}
}
