package org.example.studentmanagementsystem.repository;

import org.example.studentmanagementsystem.Enum.ChangeStatus;
import org.example.studentmanagementsystem.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity,Long>, JpaSpecificationExecutor<CourseEntity>
{
    Optional<CourseEntity> findByCourseName(String courseName);

    List<CourseEntity> findAllByStatus(ChangeStatus status);

    Optional<CourseEntity> findByIdAndStatus(Long id, ChangeStatus status);

}
