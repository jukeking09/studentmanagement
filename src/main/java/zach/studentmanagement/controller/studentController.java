package zach.studentmanagement.controller;

import ch.qos.logback.classic.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zach.studentmanagement.model.course;
import zach.studentmanagement.model.student;
import zach.studentmanagement.model.subject;
import zach.studentmanagement.service.studentService;
import zach.studentmanagement.service.subjectService;
import zach.studentmanagement.service.courseService;

import java.util.List;
import java.util.Set;

@Controller
public class studentController {
    @Autowired
    studentService studentService;

    @Autowired
    courseService courseService;

    @Autowired
    subjectService subjectService;

//    @GetMapping("/students")
//    public String getAllStudents(Model model) {
//        List<student> students = studentService.getAllstudents();
//        model.addAttribute("listStudents", students);
//        model.addAttribute("student", new student());
//        model.addAttribute("courses", courseService.getAllCourses());
//        model.addAttribute("subjects", subjectService.getAllsubjects());
//        return "StudentForm";
//    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") student student, @RequestParam("courseId") Long courseId) {
        course course = courseService.getCourseById(courseId).get();
        student.setCourse(course);
        studentService.createstudent(student);
        List<student> students = studentService.getAllstudents();
        System.out.println(students);
        return "redirect:/createStudent";
    }
    @GetMapping("/createStudent")
    public String createStudent(Model model) {
        student newStudent = new student();
        List<course> courseList = courseService.getAllCourses();
        model.addAttribute("student", newStudent);
        model.addAttribute("courses", courseList );
        List<student> students = studentService.getAllstudents();
        model.addAttribute("listStudents", students);
        model.addAttribute("student1", new student());
        model.addAttribute("courses1", courseService.getAllCourses());
        model.addAttribute("subjects", subjectService.getAllsubjects());
        return "StudentForm";
    }



    @GetMapping("/subjectList/{course_id}")
    public ResponseEntity<Set<subject>> getSubjectsByCourseId(@PathVariable("course_id") Long courseId) {
        try {
            course course = courseService.getCourseById(courseId).get();

            if (course == null) {
                return ResponseEntity.notFound().build();
            }

            Set<subject> subjects = course.getSubjects();
            return ResponseEntity.ok(subjects);
        } catch (Exception e) {
            // Log the error for further investigation
            Logger logger = null;
            logger.error("Error fetching subjects for course " + courseId, e);
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        student student = studentService.getstudentById(id).get();
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("subjects", subjectService.getAllsubjects());
        return "StudentForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deletestudent(id);
        return "redirect:/createStudent";
    }
    @GetMapping("/favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
        // Do nothing - just return an empty response to prevent 404 errors
    }
}


