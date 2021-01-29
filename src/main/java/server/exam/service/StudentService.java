package server.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import server.exam.model.Student;
import server.exam.model.Supervisor;
import server.exam.repository.StudentRepository;
import server.exam.repository.SupervisorRepository;

import java.util.*;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SupervisorRepository supervisorRepository;

    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    public ResponseEntity<Student> createStudent(Student student){
        Boolean supervisorExists = supervisorRepository.existsBySupervisorId(student.getSupervisor().getSupervisorId());

         Boolean isNew = studentRepository.existsByStudentEmail(student.getStudentEmail());

        if (!isNew && supervisorExists) {
            Supervisor supervisor = supervisorRepository.findById(student.getSupervisor().getSupervisorId()).get();
            student.setSupervisor(supervisor);
            Student newStudent = studentRepository.save(student);
            return new ResponseEntity<>(newStudent,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    public ResponseEntity<Student> updateStudent(int student_id, Student student){
        if (student_id < 0 ){
            return new ResponseEntity<>(student,HttpStatus.NO_CONTENT);
        }
        Student student1 = studentRepository.findById(student_id).get();
        student1.setStudentName(student.getStudentName());
        student1.setStudentEmail(student.getStudentEmail());
        Supervisor supervisor = supervisorRepository.findById(student.getSupervisor().getSupervisorId()).get();
        student1.setSupervisor(supervisor);
        System.out.print(student1);
        studentRepository.save(student1);
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }

    public ResponseEntity<Student> deleteStudent(int studentId){
        Student student = studentRepository.findById(studentId).get();
        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
