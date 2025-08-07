package com.cloud.hrworker.controller;

import com.cloud.hrworker.entities.Worker;
import com.cloud.hrworker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private WorkerRepository repository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs(){
        logger.info("CONFIG= {}", testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable long id){
        return ResponseEntity.ok(repository.findById(id).orElse(null));
    }

}
