package zach.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zach.studentmanagement.model.subject;
import zach.studentmanagement.repository.subjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class subjectService {

    @Autowired
    private subjectRepository subjectRepository;

    // Create a new subject
    public subject createsubject(subject subject) {
        return subjectRepository.save(subject);
    }

    // Retrieve a subject by its ID
    public Optional<subject> getsubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    // Retrieve all subjects
    public List<subject> getAllsubjects() {
        return subjectRepository.findAll();
    }

    // Update an existing subject
    public subject updatesubject(Long id, subject subjectDetails) {
        Optional<subject> optionalsubject = subjectRepository.findById(id);
        if (optionalsubject.isPresent()) {
            subject subject = optionalsubject.get();
            subject.setSubject_name(subjectDetails.getSubject_name());
//            subject.setCourses(subjectDetails.getCourses());
            return subjectRepository.save(subject);
        } else {
            throw new RuntimeException("subject not found with id " + id);
        }
    }

    // Delete a subject by its ID
    public void deletesubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
