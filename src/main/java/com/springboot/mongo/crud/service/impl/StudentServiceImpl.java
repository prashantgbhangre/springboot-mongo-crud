package com.springboot.mongo.crud.service.impl;

import com.springboot.mongo.crud.exception.SpringBootMongoCrudException;
import com.springboot.mongo.crud.infrastructure.entity.StudentEntity;
import com.springboot.mongo.crud.infrastructure.repository.StudentRepository;
import com.springboot.mongo.crud.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAllStudent() throws SpringBootMongoCrudException {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        if (studentEntityList == null) {
            throw new SpringBootMongoCrudException("Data not found", HttpStatus.NOT_FOUND);
        }
        return studentEntityList;
    }

    @Override
    public StudentEntity getSingleStudent(String id) throws SpringBootMongoCrudException {
        if (StringUtils.isEmpty(id)) {
            throw new SpringBootMongoCrudException("Invalid id : " + id, HttpStatus.NOT_FOUND);
        }
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (!studentEntity.isPresent()) {
            throw new SpringBootMongoCrudException("Data not found", HttpStatus.NOT_FOUND);
        }
        return studentEntity.get();
    }

    @Override
    public ResponseEntity createStudent(StudentEntity studentEntity) throws URISyntaxException, SpringBootMongoCrudException {
        if (studentEntity == null) {
            throw new SpringBootMongoCrudException("Invalid data : " + studentEntity, HttpStatus.NOT_FOUND);
        }
        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);
        if (savedStudentEntity != null) {
            return ResponseEntity.created(new URI("/student/" + savedStudentEntity.getId())).body(savedStudentEntity);
        } else {
            throw new SpringBootMongoCrudException("Invalid data : " + studentEntity, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity updateStudent(StudentEntity studentEntity) throws SpringBootMongoCrudException {
        if (studentEntity == null) {
            throw new SpringBootMongoCrudException("Invalid data : " + studentEntity, HttpStatus.NOT_FOUND);
        }
        Optional<StudentEntity> currentStudentEntityOptional = studentRepository.findById(studentEntity.getId());
        if (currentStudentEntityOptional.isPresent()) {
            StudentEntity currentStudentEntity = currentStudentEntityOptional.get();
            BeanUtils.copyProperties(studentEntity, currentStudentEntity);
            currentStudentEntity = studentRepository.save(currentStudentEntity);
            return ResponseEntity.ok(currentStudentEntity);
        } else {
            throw new SpringBootMongoCrudException("Invalid data : " + studentEntity, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity deleteStudent(String id) throws SpringBootMongoCrudException {
        if (StringUtils.isEmpty(id)) {
            throw new SpringBootMongoCrudException("Invalid id : " + id, HttpStatus.NOT_FOUND);
        }
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
