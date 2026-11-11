package com.attendance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Batch {
    @Id
    private String batchCode;
    private String batchDays;
    private String batchTime;
    private String semesterName;
    private String semesterBook; // Yahan 'bookName' ki jagah 'semesterBook' kar diya hai
    private String teacherName;
    private String batchStatus;
    private String date;

    // Getters and Setters
    public String getBatchCode() { return batchCode; }
    public void setBatchCode(String batchCode) { this.batchCode = batchCode; }
    
    public String getBatchDays() { return batchDays; }
    public void setBatchDays(String batchDays) { this.batchDays = batchDays; }
    
    public String getBatchTime() { return batchTime; }
    public void setBatchTime(String batchTime) { this.batchTime = batchTime; }
    
    public String getSemesterName() { return semesterName; }
    public void setSemesterName(String semesterName) { this.semesterName = semesterName; }
    
    public String getSemesterBook() { return semesterBook; }
    public void setSemesterBook(String semesterBook) { this.semesterBook = semesterBook; }
    
    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    
    public String getBatchStatus() { return batchStatus; }
    public void setBatchStatus(String batchStatus) { this.batchStatus = batchStatus; }
    
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}