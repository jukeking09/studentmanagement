package zach.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zach.studentmanagement.model.subject;

import java.util.List;

@Repository
public interface subjectRepository extends JpaRepository<subject,Long> {
}
