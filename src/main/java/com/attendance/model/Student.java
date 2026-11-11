package com.attendance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private String id;

    private String studentId;
    private String totalStudents;
    private String studentName;
    private String semesterName;
    private String batchCode;    
    private String semesterBook;
    private String timing;       
    private String date;
    private String days;         
    private String teacherName;
    private String status;       
    private String teacherId;

    public Student() {}

    // Getters and Setters with full synchronization
    public String getId() { 
        return id != null ? id : studentId; 
    }
    
    public void setId(String id) { 
        this.id = id; 
        this.studentId = id; 
    }

    public String getStudentId() { 
        return studentId != null ? studentId : id; 
    }
    
    public void setStudentId(String studentId) { 
        this.studentId = studentId; 
        this.id = studentId; 
    }

    public String getTotalStudents() { return totalStudents; }
    public void setTotalStudents(String totalStudents) { this.totalStudents = totalStudents; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getSemesterName() { return semesterName; }
    public void setSemesterName(String semesterName) { this.semesterName = semesterName; }

    // Batch mapping for both batchCode and studentBatch
    public String getBatchCode() { return batchCode; }
    public void setBatchCode(String batchCode) { this.batchCode = batchCode; }
    
    public String getStudentBatch() { return batchCode; }
    public void setStudentBatch(String studentBatch) { this.batchCode = studentBatch; }

    public String getSemesterBook() { return semesterBook; }
    public void setSemesterBook(String semesterBook) { this.semesterBook = semesterBook; }

    // Timing mapping for both timing and studentTiming
    public String getTiming() { return timing; }
    public void setTiming(String timing) { this.timing = timing; }

    public String getStudentTiming() { return timing; }
    public void setStudentTiming(String studentTiming) { this.timing = studentTiming; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    // Days mapping for both days and studentDays
    public String getDays() { return days; }
    public void setDays(String days) { this.days = days; }

    public String getStudentDays() { return days; }
    public void setStudentDays(String studentDays) { this.days = studentDays; }

    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    // Status mapping for both status and studentStatus
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStudentStatus() { return status; }
    public void setStudentStatus(String studentStatus) { this.status = studentStatus; }

    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }
}