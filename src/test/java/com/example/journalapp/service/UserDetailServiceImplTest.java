package com.example.journalapp.service;

import com.example.journalapp.entity.User;
import com.example.journalapp.repositry.UserEntryRepositry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.mockito.Mockito.*;


public class UserDetailServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserEntryRepositry userEntryRepositry;

    @Disabled
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Disabled
    @Test
    void loadBYUserNameTest() {
        when(userEntryRepositry.findByuserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Anish").password("bjbjdsb").roles(Collections.singletonList("ADMIN")).build());
        UserDetails user = userDetailsService.loadUserByUsername("Anish");
        Assertions.assertNotNull(user);
    }
}
