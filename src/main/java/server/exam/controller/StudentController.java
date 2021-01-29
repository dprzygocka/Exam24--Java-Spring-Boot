package server.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.exam.model.Student;
import server.exam.service.StudentService;

import java.util.List;

    @CrossOrigin
    @RequestMapping("/api/students")
    @RestController
    public class StudentController {

    @Autowired
    StudentService studentService;

        @GetMapping
        public ResponseEntity<List<Student>> getStudents() {
            return studentService.getStudents();
        }

        @PostMapping
        public ResponseEntity<Student> createStudent(@RequestBody Student student){
            return studentService.createStudent(student);
        }

        @PutMapping("/{student_id}")
        public ResponseEntity<Student> updateStudent(@PathVariable("student_id") int studentId, @RequestBody Student student){
            return studentService.updateStudent(studentId, student);
        }

        @DeleteMapping("/{student_id}")
        public ResponseEntity<Student> deleteStudent(@PathVariable("student_id") int studentId){
            return studentService.deleteStudent(studentId);
        }

    }
