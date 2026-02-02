package org.example.studentmanagementsystem.repository;

import org.example.studentmanagementsystem.Enum.DeleteFlag;
import org.example.studentmanagementsystem.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity,Long>
{
    Optional<CourseEntity> findByCourseName(String courseName);

    List<CourseEntity> findAllByDeleteFlag(DeleteFlag deleteFlag);

    Optional<CourseEntity> findByIdAndDeleteFlag(Long id,DeleteFlag deleteFlag);

}
