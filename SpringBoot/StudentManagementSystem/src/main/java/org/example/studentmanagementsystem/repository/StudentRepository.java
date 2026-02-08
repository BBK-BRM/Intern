package org.example.studentmanagementsystem.repository;

import org.example.studentmanagementsystem.Enum.ChangeStatus;
import org.example.studentmanagementsystem.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long>, JpaSpecificationExecutor<StudentEntity> {

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<StudentEntity> findByIdAndDeleteFlag(Long id, ChangeStatus deleteFlag);

    List<StudentEntity> findAllByDeleteFlag(ChangeStatus deleteFlag);

}
