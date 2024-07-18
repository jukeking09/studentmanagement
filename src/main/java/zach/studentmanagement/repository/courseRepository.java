package zach.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zach.studentmanagement.model.course;

@Repository
public interface courseRepository extends JpaRepository<course,Long> {

}
