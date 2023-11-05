package org.Binar.Challenge.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.Binar.Challenge.model.Users;
import org.Binar.Challenge.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateUser() {
        // Buat objek Users yang akan digunakan dalam pengujian
        Users existingUser = new Users();
        existingUser.setId("1");
        existingUser.setUsername("user123");
        existingUser.setEmail("user@example.com");
        existingUser.setPassword("password123");

        Users updatedUser = new Users();
        updatedUser.setId("1");
        updatedUser.setUsername("updatedUser");
        updatedUser.setEmail("updated@example.com");
        updatedUser.setPassword("updatedPassword");

        // Konfigurasi perilaku mock untuk userService
        when(userService.getUserById("1")).thenReturn(existingUser);
        when(userService.updateUser(existingUser)).thenReturn(updatedUser);

        // Panggil metode yang akan diuji
        ResponseEntity<Users> responseEntity = userController.updateUser("1", updatedUser);

        // Verifikasi bahwa metode getUserById dan updateUser pada userService telah dipanggil dengan benar
        verify(userService, times(1)).getUserById("1");
        verify(userService, times(1)).updateUser(existingUser);

        // Verifikasi bahwa respon sesuai dengan yang diharapkan
        assertEquals(ResponseEntity.ok(updatedUser), responseEntity);
    }
}
