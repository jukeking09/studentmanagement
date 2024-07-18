package zach.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zach.studentmanagement.model.student;

@Repository
public interface studentRepository extends JpaRepository<student,Long> {
}
