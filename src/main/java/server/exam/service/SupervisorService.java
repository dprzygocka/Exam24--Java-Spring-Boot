package server.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import server.exam.model.Supervisor;
import server.exam.repository.SupervisorRepository;

import java.util.List;

@Service
public class SupervisorService {
    @Autowired
    SupervisorRepository supervisorRepository;

    public ResponseEntity<List<Supervisor>> getSupervisors(){
        List<Supervisor> supervisors = supervisorRepository.findAll();
        if(supervisors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(supervisors, HttpStatus.OK);
    }
}
