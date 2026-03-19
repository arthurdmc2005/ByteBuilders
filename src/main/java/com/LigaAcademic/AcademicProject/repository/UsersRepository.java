package com.LigaAcademic.AcademicProject.repository;

import com.LigaAcademic.AcademicProject.User.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, String> {

    UserDetails findByEmail(String email);
}
