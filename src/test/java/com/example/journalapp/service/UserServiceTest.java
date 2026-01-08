package com.example.journalapp.service;

import com.example.journalapp.entity.User;
import com.example.journalapp.repositry.UserEntryRepositry;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserEntryRepositry userEntryRepositry;

    @Autowired
    private UserEntryService userEntryService;


    @ParameterizedTest
//    @CsvSource({
//            "Tom",
//            "Jhon",
//            "Anish",
//            "Jonny"
//    })
    @Disabled
    @ArgumentsSource(UserArguementProvider.class)
    public void testSaveNewUser(User user) {
//        User user = userEntryRepositry.findByuserName(name);
//        assertTrue(!user.getJournalEntries().isEmpty());
//        assertNotNull(userEntryRepositry.findByuserName(name),"failed for: " + name);
        assertTrue(userEntryService.saveNewUser(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b , int expected) {
        assertEquals(expected,a+b);
    }

    /// Another usefull annotations
//    @BeforeAll
//    @BeforeEach
//    @AfterAll
//    @AfterEach
}
