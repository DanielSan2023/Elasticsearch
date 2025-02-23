package com.elasticsearch.entity;

import com.elasticsearch.helper.Indices;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = Indices.VEHICLE_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Vehicle {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    private String number;

    @Field(type = FieldType.Text)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;
}
