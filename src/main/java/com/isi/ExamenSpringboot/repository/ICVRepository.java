package com.isi.ExamenSpringboot.repository;

import com.isi.ExamenSpringboot.entity.CVEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICVRepository extends JpaRepository<CVEntity, Integer> {
    CVEntity findByEmail(String email);

}
