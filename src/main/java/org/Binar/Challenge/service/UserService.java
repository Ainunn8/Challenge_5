package org.Binar.Challenge.service;

import org.Binar.Challenge.model.Users;

import java.util.List;

public interface UserService {

    // Menambahkan user baru
    Users addUsers(Users users);

    // Mengupdate detail user
    Users updateUser(Users user);
    Users getUserById(String id);


    // Menghapus user berdasarkan userId
    void deleteUsers(String usersId);

    List<Users> getAllUser();

}
