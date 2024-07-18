package zach.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zach.studentmanagement.model.student;
import zach.studentmanagement.repository.studentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class studentService {

    @Autowired
    private studentRepository studentRepository;

    // Create a new student
    public student createstudent(student student) {
        return studentRepository.save(student);
    }

    // Retrieve a student by their ID
    public Optional<student> getstudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Retrieve all students
    public List<student> getAllstudents() {
        return studentRepository.findAll();
    }

    // Update an existing student
    public student updatestudent(Long id, student studentDetails) {
        Optional<student> optionalstudent = studentRepository.findById(id);
        if (optionalstudent.isPresent()) {
            student student = optionalstudent.get();
            student.setStudent_name(studentDetails.getStudent_name());
            student.setSubjects(studentDetails.getSubjects());
            // Add other fields to update here

            return studentRepository.save(student);
        } else {
            throw new RuntimeException("student not found with id " + id);
        }
    }

    // Delete a student by their ID
    public void deletestudent(Long id) {
        studentRepository.deleteById(id);
    }
}
