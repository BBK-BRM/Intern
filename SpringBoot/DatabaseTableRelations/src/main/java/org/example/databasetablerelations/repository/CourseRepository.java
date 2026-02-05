package org.example.databasetablerelations.repository;

import org.example.databasetablerelations.entity.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CoursesEntity,Long> {
    boolean existsByCourseName(String courseName);
}
