package zach.studentmanagement.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    private String student_name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private course course;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    )
    private Set<subject> subjects = new HashSet<>();

    public Set<subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<subject> subjects) {
        this.subjects = subjects;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public course getCourse() {
        return course;
    }

    public void setCourse(course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", course=" + course +
                ", subjects=" + subjects +
                '}';
    }
}
