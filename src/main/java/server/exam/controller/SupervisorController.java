package server.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.exam.model.Supervisor;
import server.exam.repository.SupervisorRepository;
import server.exam.service.SupervisorService;

import java.util.List;
@CrossOrigin
@RequestMapping("/api/supervisors")
@RestController
public class SupervisorController {

    @Autowired
    SupervisorService supervisorService;

    @GetMapping
    public ResponseEntity<List<Supervisor>> getSupervisors(){
        return supervisorService.getSupervisors();
    }

}
