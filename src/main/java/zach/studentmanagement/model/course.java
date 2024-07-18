package zach.studentmanagement.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Course_id;
    private String Course_name;

    @OneToMany(mappedBy = "course")
    private List<student> students;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "course_subjects",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    )
    private Set<subject> subjects = new HashSet<>();
    public Long getCourse_id() {
        return Course_id;
    }

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }

    public Set<subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<subject> subjects) {
        this.subjects = subjects;
    }

    public void setCourse_id(Long course_id) {
        Course_id = course_id;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String course_name) {
        Course_name = course_name;
    }

    @Override
    public String toString() {
        return "course{" +
                "Course_id=" + Course_id +
                ", Course_name='" + Course_name + '\'' +
                ", students=" + students +
                ", subjects=" + subjects +
                '}';
    }
}
