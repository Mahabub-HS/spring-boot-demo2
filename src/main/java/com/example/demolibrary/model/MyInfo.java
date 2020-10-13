package com.example.demolibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyInfo {
    private String webService;
    private String version;
    private String name;
    private long id;

}
