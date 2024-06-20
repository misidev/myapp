package com.myapp.spring_myapp_service.repository;


import com.myapp.spring_myapp_service.model.MessageDifferentLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<MessageDifferentLanguage, Long> {
    MessageDifferentLanguage findByLang(String lang);
}
