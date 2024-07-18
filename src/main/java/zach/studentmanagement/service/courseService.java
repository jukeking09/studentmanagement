package zach.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zach.studentmanagement.model.course;
import zach.studentmanagement.repository.courseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class courseService {

    @Autowired
    private courseRepository courseRepository;

    // Create a new course
    public course createCourse(course course) {
        return courseRepository.save(course);
    }

    // Retrieve a course by its ID
    public Optional<course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Retrieve all courses
    public List<course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Update an existing course
    public course updateCourse(Long id, course courseDetails) {
        Optional<course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            course course = optionalCourse.get();
            course.setCourse_name(courseDetails.getCourse_name());
            return courseRepository.save(course);
        } else {
            throw new RuntimeException("Course not found with id " + id);
        }
    }

    // Delete a course by its ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
