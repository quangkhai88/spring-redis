package com.tqk;

import com.tqk.bean.Student;
import com.tqk.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

/**
 * Created by khaitq
 * Date: 29/04/2018 - Paris, France
 * Github:  https://github.com/quangkhai88
 */

@Service
@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        if (student != null) {
            studentRepository.save(student);
        }
        return student;
    }

    public Student findStudent(String id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Student> findAll() {

        List<Student> studentList = new ArrayList<Student>();
        studentRepository.findAll().forEach(student -> studentList.add(student));
        return  studentList;
    }

    public void deleteStudentById(String id) {

        studentRepository.deleteById(id);

    }

    public void deleteAllStudent() {

        studentRepository.deleteAll();
    }

}
