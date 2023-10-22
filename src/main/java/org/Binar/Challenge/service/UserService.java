package org.Binar.Challenge.service;

import org.Binar.Challenge.model.Users;

import java.util.List;

public interface UserService {

    // Menambahkan user baru
    Users addUsers(Users users);

    // Mengupdate detail user
    boolean updateUsers(String users, String newUserid);

    // Menghapus user berdasarkan userId
    void deleteUsers(String usersId);

    List<Users> getAllUser();

}
