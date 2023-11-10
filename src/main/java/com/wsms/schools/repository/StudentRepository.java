package com.wsms.schools.repository;

import com.wsms.schools.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT e FROM Student e where e.entryClassAssigned = :assignedClass")
    List<Student>  findByEntryClassAssigned(@Param("assignedClass") String assignedClass);
}
