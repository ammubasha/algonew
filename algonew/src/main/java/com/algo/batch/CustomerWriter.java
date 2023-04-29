package com.algo.batch;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.FileSystemResource;

public class CustomerWriter extends FlatFileItemWriter<Person> {
	
	private final String OUTPUT_FILE = "output/customers.csv";

    public CustomerWriter() {
        setResource(new FileSystemResource(OUTPUT_FILE));

        // map properties to CSV columns
        setLineAggregator(customer -> String.format("%s,%s",  customer.getFirstName(), customer.getLastName()));

        // add header to CSV
        String[] header = {"ID", "fName", "lname"};
        setHeaderCallback(writer -> writer.write(String.join(",", header)));
    }

}
