package com.algo.batch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("algohistory")
public class AlgoController {
    
    @GetMapping(produces = "application/json")
    public String getBook(@PathVariable int id) {
        return "algoWorkingFine";
    }

  
}

