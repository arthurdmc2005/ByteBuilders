package com.LigaAcademic.AcademicProject.repository;

import com.LigaAcademic.AcademicProject.model.ContabilHoras;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContabilHorasRepository extends JpaRepository<ContabilHoras,Long> {



}
