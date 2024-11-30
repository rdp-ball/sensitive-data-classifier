package com.aurva.rolwin.assignment.repository;

import com.aurva.rolwin.assignment.entity.FilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository<FilesEntity, Integer> {
    FilesEntity findById(int id);
}
