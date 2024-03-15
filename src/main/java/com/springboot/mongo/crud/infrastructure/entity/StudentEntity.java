package com.springboot.mongo.crud.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "studentCollection")
public class StudentEntity implements Serializable {

    public StudentEntity() {
    }

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String status = "1";
    private Date createdDate;
    private Date updatedDate;
}
