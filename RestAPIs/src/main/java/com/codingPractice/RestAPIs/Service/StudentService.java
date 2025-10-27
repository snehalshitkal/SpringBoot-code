package com.codingPractice.RestAPIs.Service;

import com.codingPractice.RestAPIs.dto.AddStudentRequestDto;
import com.codingPractice.RestAPIs.dto.Studentdto;

import java.util.List;
import java.util.Map;

public interface StudentService
{
    List<Studentdto> getAllStudents();

    Studentdto getStudentById(Long id);

    Studentdto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    Studentdto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    Studentdto updatePartialStudent(Long id, Map<String, Object> updates);
}
