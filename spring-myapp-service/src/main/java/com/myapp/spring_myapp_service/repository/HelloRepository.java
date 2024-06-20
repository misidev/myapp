package com.myapp.spring_myapp_service.repository;

import com.myapp.spring_myapp_service.model.MessageDifferentLanguage;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<MessageDifferentLanguage, Long> {

    MessageDifferentLanguage findByLangIgnoreCase(String lang);

    MessageDifferentLanguage findByLangStartsWith(String lang, Sort sort);

    MessageDifferentLanguage findByLangEndsWith(String lang);


    MessageDifferentLanguage findBylang(String cao_svete);

    //HelloEntity findByLangContaining(String word);

    // HelloEntity findByLangIn(Collection<HelloEntity> hellos);

}
