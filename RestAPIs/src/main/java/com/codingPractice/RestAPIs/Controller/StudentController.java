package com.codingPractice.RestAPIs.Controller;

import com.codingPractice.RestAPIs.Entity.Student;
import com.codingPractice.RestAPIs.Repository.StudentRepository;
import com.codingPractice.RestAPIs.Service.StudentService;
import com.codingPractice.RestAPIs.dto.AddStudentRequestDto;
import com.codingPractice.RestAPIs.dto.Studentdto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public ResponseEntity<List<Studentdto>> getAllStudents()
    {
       // return ResponseEntity.status(HttpStatus.ok).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping("/{id}")
    public  ResponseEntity getStudentById(@PathVariable Long id)
    {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Studentdto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto)
    {
        return  ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studentdto>updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto)
    {
        return  ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Studentdto>updatePartialStudent(@PathVariable Long id, @RequestBody Map<String,Object>updates)
    {
        return  ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }
}
