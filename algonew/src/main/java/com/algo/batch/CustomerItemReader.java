package com.algo.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

public class CustomerItemReader extends JdbcCursorItemReader<Person>{
	
    public CustomerItemReader(DataSource dataSource) {
        setDataSource(dataSource);
        setSql(getSql());
        setRowMapper(new CustomerRowMapper());
    }
    
    public String getSql() {
    	String sql = "";
    	if(true) 
    		sql = "SELECT first_name,last_name FROM People";
    		
    		else
    			
    		  sql = "SELECT id, last_name FROM people";
    	
    	return sql;
    }

    private class CustomerRowMapper implements RowMapper<Person> {

        public CustomerRowMapper() {
			// TODO Auto-generated constructor stub
		}

		@Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person customer = new Person();
            customer.setLastName(resultSet.getString("last_name"));
            customer.setFirstName(resultSet.getString("first_name"));
            return customer;
        }
    }

}
