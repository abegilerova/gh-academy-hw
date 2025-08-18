package org.example.fileHandlingPart2;

import java.io.Serializable;

public class AcademyGroup implements Serializable {
    private int id;
    private String groupName;
    private int academyId;



    public AcademyGroup(int id, String groupName, int academyId) {
        this.id = id;
        this.groupName = groupName;
        this.academyId = academyId;
    }
}
