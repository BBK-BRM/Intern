package org.example.studentmanagementsystem.repository;

import org.example.studentmanagementsystem.Enum.DeleteFlag;
import org.example.studentmanagementsystem.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<StudentEntity> findByIdAndDeleteFlag(Long id,DeleteFlag deleteFlag);

    List<StudentEntity> findAllByDeleteFlag(DeleteFlag deleteFlag);

}
