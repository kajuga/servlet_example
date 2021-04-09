package com.fedorov.model_json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "id", "name", "age"})
public class JacksonUser {
    private int id;
    private String name;
    private int age;
  }
