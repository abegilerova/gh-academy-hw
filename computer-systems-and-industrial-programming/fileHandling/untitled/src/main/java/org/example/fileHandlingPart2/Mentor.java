package org.example.fileHandlingPart2;

import java.io.Serializable;

public class Mentor implements Serializable {
    private int id;
    private String name;
    private String academyId;


    public Mentor(int id, String name, String academyId) {
        this.id = id;
        this.name = name;
        this.academyId = academyId;
    }
}
