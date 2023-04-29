package com.algo.batch;

import java.util.List;

import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("batchalgo")
public class BatchController {
	    
	    @Autowired
	    private JobExplorer jobExplorer;


	    @PostMapping("/run")
	    public ResponseEntity<String> runJob() throws Exception {
	      
	    	List<String> jobnames = jobExplorer.getJobNames();
	        return ResponseEntity.ok()
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(String.format("{ \"JobName\": \"%s\" }", jobnames));
	    }

}
