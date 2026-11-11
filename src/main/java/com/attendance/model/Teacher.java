package com.attendance.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherId;
    
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String teacherPassword;

    @Column(nullable = false)
    private String teacherName;

    private String teacherStatus;
    
    private String date;

    public Teacher() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getTeacherPassword() { return teacherPassword; }
    public void setTeacherPassword(String teacherPassword) { this.teacherPassword = teacherPassword; }

    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    public String getTeacherStatus() { return teacherStatus; }
    public void setTeacherStatus(String teacherStatus) { this.teacherStatus = teacherStatus; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}