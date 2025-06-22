package com.example.servingwebcontent.model;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "course_id", length = 50)
    private String courseID;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "credits")
    private int credits;

    @Column(name = "status")
    private String status; // "Studying", "Retaking", "Completed"

    public Course() {}

    public Course(String courseID, String courseName, int credits, String status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.status = status;
    }

    // Getter & Setter
    public String getCourseID() { return courseID; }
    public void setCourseID(String courseID) { this.courseID = courseID; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "CourseID: " + courseID + ", Name: " + courseName + 
               ", Credits: " + credits + ", Status: " + status;
    }
}
