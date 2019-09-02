package com.example.testingApachePOI.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String name;

    private String age;
}
