package com.springboot.mongo.crud.service;

import com.springboot.mongo.crud.exception.SpringBootMongoCrudException;
import com.springboot.mongo.crud.infrastructure.entity.StudentEntity;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;

public interface StudentService {
    public List<StudentEntity> getAllStudent() throws SpringBootMongoCrudException;
    public StudentEntity getSingleStudent(String id) throws SpringBootMongoCrudException;
    public ResponseEntity createStudent(StudentEntity StudentEntity) throws URISyntaxException , SpringBootMongoCrudException;
    public ResponseEntity updateStudent(StudentEntity StudentEntity) throws SpringBootMongoCrudException;
    public ResponseEntity deleteStudent(String id) throws SpringBootMongoCrudException;
}
