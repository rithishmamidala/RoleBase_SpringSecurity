package com.ust.UstProjects.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String projectName;
    private String projectDescription;
    @Enumerated(value = EnumType.STRING)
    private ProjectStatus projectStatus;
    private String projectLink;
    public String psNumber;

}
