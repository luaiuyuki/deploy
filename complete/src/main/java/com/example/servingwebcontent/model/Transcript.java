package com.example.servingwebcontent.model;
import jakarta.persistence.*;

@Entity
@Table(name = "transcripts")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "grade_10")
    private float grade10;

    @Column(name = "semester")
    private String semester;

    public Transcript() {}

    public Transcript(Student student, Course course, float grade10, String semester) {
        this.student = student;
        this.course = course;
        this.grade10 = grade10;
        this.semester = semester;
    }

    // Getter & Setter
    public Long getId() { return id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public float getGrade10() { return grade10; }
    public void setGrade10(float grade10) { this.grade10 = grade10; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

  
    public float getGrade4() {
        if (grade10 >= 8.5f) return 4.0f;
        else if (grade10 >= 7.0f) return 3.0f;
        else if (grade10 >= 5.5f) return 2.0f;
        else if (grade10 >= 4.0f) return 1.0f;
        else return 0.0f;
    }

    public String getLetterGrade() {
        if (grade10 >= 8.5f) return "A";
        else if (grade10 >= 7.0f) return "B";
        else if (grade10 >= 5.5f) return "C";
        else if (grade10 >= 4.0f) return "D";
        else return "F";
    }

    public String getPassFail() {
        return grade10 >= 4.0f ? "Pass" : "Fail";
    }

    public String getStatus() {
        boolean hasGrade = grade10 > 0;

        if (!hasGrade) {
            return "Studying";
        } else if (grade10 < 5.0f || "Fail".equalsIgnoreCase(getPassFail())) {
            return "Retaking";
        } else {
            return "Completed";
        }
    }

    @Override
    public String toString() {
        return student.getFullname() + " | " + course.getCourseName() +
               " | Grade10: " + grade10 +
               " | Grade4: " + getGrade4() +
               " | Letter: " + getLetterGrade() +
               " | Result: " + getPassFail() +
               " | Semester: " + semester +
               " | Status: " + getStatus();
    }
}
