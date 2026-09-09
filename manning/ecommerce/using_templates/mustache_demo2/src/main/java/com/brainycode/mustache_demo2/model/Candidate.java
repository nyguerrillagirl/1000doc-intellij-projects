package com.brainycode.mustache_demo2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    private String name;
    private int age;
    private String phoneNo;
    private String emailId;

}
