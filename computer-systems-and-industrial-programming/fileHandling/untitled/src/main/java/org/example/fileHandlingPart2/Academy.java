package org.example.fileHandlingPart2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Academy implements Serializable {
    private int id;
    private String description;
    private List<Mentor> mentors = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<AcademyGroup> groups = new ArrayList<>();

    public Academy(int id, String description){
        this.id = id;
        this.description = description;
    }
}
