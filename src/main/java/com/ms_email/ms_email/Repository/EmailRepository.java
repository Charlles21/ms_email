package com.ms_email.ms_email.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms_email.ms_email.Model.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{
    
}
