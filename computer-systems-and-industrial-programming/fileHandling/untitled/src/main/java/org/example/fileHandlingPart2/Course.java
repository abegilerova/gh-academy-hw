package org.example.fileHandlingPart2;

import java.io.Serializable;

public class Course implements Serializable {
    private int id;
    private String name;
    private int academyId;


    public Course(int id, String name, int academyId) {
        this.id = id;
        this.name = name;
        this.academyId = academyId;
    }
}
