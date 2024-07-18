package zach.studentmanagement.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subject_id;
    private String subject_name;

//    @ManyToMany(mappedBy = "subjects" , cascade = CascadeType.ALL)
////    private Set<course> courses = new HashSet<>();
//
////    @ManyToMany(mappedBy = "subjects" , cascade = CascadeType.ALL)
////    private Set<student> students = new HashSet<>();

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

//    public Set<course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Set<course> courses) {
//        this.courses = courses;
//    }
//
//    public Set<student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<student> students) {
//        this.students = students;
//    }


    @Override
    public String toString() {
        return "subject{" +
                "subject_id=" + subject_id +
                ", subject_name='" + subject_name + '\'' +
                '}';
    }
}
