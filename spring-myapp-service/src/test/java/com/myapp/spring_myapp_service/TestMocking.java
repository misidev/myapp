package com.myapp.spring_myapp_service;

import com.myapp.spring_myapp_service.model.MessageDifferentLanguage;
import com.myapp.spring_myapp_service.repository.HelloRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
public class TestMocking {
    private static final Logger LOGGER = LogManager.getLogger(TestMocking.class);
    //    @Mock
    MessageDifferentLanguage messageDifferentLanguage;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HelloRepository helloRepository;

    @BeforeMethod
    public void setupMock() {

        LOGGER.info("Test started");
        long startTime = System.currentTimeMillis();
        startTime = System.currentTimeMillis();
        System.out.println("start time is: " + startTime + "ms");

        messageDifferentLanguage = mock(MessageDifferentLanguage.class);
        when(messageDifferentLanguage.getLang()).thenReturn("English");
        when(messageDifferentLanguage.getMessageDifLang()).thenReturn("Hello World");
    }

    @Test
    void testMessageDifferentLanguageExists() throws ClassNotFoundException {
        //tests whether class exists
        try {
            Class a = Class.forName("com.example.demo.model.MessageDifferentLanguage");
            Assert.assertNotEquals("Test passed - class exists", a, null);
        } catch (AssertionError | ClassNotFoundException e) {
            assert false : "Test failed - class does not exist";
            e.printStackTrace();
        }

    }

    @Test
    public void lang() {
        try {
            System.out.println("Lang: " + messageDifferentLanguage.getLang());
            assertEquals("English", messageDifferentLanguage.getLang());
        } catch (AssertionError e) {
            assert false : "Test failed";
            e.printStackTrace();
        }
    }

    @Test
    public void messageDifferentLanguageFromEntity() {
        try {
            System.out.println("Message Hello World in English: " + messageDifferentLanguage.getMessageDifLang());
            assertEquals("Hello World", messageDifferentLanguage.getMessageDifLang());
        } catch (AssertionError e) {
            assert false : "Test failed";
            e.printStackTrace();
        }
    }

//    @Test
//    public void helloLangSaveNew() {
//        entityManager.persist(new HelloEntity(11L, "Srpski", "Cao svete"));
//        HelloEntity helloEntity1 = helloRepository.findBylang("Cao svete");
//        assertThat(helloEntity1.getLang()).isEqualTo("Cao svete");
//    }

    @AfterEach
    void tearDown() {
        LOGGER.info("Test ended");
        long startTime = System.currentTimeMillis();
        startTime = System.currentTimeMillis();
        System.out.println("end time is: " + startTime + "ms");
    }

}





