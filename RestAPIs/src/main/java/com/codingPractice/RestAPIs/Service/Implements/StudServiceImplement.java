package com.codingPractice.RestAPIs.Service.Implements;

import com.codingPractice.RestAPIs.Entity.Student;
import com.codingPractice.RestAPIs.Repository.StudentRepository;
import com.codingPractice.RestAPIs.Service.StudentService;
import com.codingPractice.RestAPIs.dto.AddStudentRequestDto;
import com.codingPractice.RestAPIs.dto.Studentdto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudServiceImplement implements StudentService
{
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudServiceImplement(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Studentdto>  getAllStudents()
    {
        List<Student> students = studentRepository.findAll();

        List<Studentdto> studentDtoList = students
                            .stream()
                            .map(student -> new Studentdto(student.getId(),student.getName(),student.getEmail()))
                            .toList();

        return List.of();
    }

    @Override
    public Studentdto getStudentById(Long id) {
        Student student =  studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found with id:"+id));

        return modelMapper.map(student,Studentdto.class);
    }

    @Override
    public Studentdto createNewStudent(AddStudentRequestDto addStudentRequestDto) {

        Student newStudent =  modelMapper.map(addStudentRequestDto,Student.class);
        Student student = studentRepository.save(newStudent);
        return  modelMapper.map(student,Studentdto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id))
        {
            throw new IllegalArgumentException("Student does not exists"+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Studentdto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {

        Student student =  studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("student not found with id:"+id));

        modelMapper.map(addStudentRequestDto,student);
        student = studentRepository.save(student);
        return  modelMapper.map(student,Studentdto.class);

    }

    @Override
    public Studentdto updatePartialStudent(Long id, Map<String, Object> updates) {

        Student student =  studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("student not found with id:"+id));
        updates.forEach((field,value)->{
            switch (field)
            {
                case "name":
                    student.setName((String)value);
                    break;
                case "email":
                    student.setEmail((String)value);
                    break;
                default:
                    throw  new IllegalArgumentException("Field is not support");
            }
        });

        Student savestudent = studentRepository.save(student);
        return  modelMapper.map(savestudent,Studentdto.class);

    }


}
