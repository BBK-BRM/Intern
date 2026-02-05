package org.example.databasetablerelations.repository;

import org.example.databasetablerelations.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentsEntity,Long> {
}
