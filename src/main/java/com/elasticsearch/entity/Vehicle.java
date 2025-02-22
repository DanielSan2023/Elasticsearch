package com.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "vehicle")
public class Vehicle {
    private String id;
    private String number;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

}
