package com.springboot.mongo.crud.infrastructure.repository;

import com.springboot.mongo.crud.infrastructure.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity, String> {

    List<StudentEntity> getStudentByStatus(String status);
}
