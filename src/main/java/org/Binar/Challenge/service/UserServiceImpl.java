package org.Binar.Challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.model.Users;
import org.Binar.Challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Users addUsers(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteUsers(String usersId) {
        // Mencari pengguna berdasarkan ID
        Users user = userRepository.findById(usersId).orElse(null);

        if (user != null) {
            // Menghapus pengguna dari basis data
            userRepository.delete(user);
            System.out.println("Pengguna dengan ID " + usersId + " berhasil dihapus.");
        } else {
            System.out.println("Pengguna dengan ID " + usersId + " tidak ditemukan.");
        }
//        userRepository.deleteById(usersId);
    }

    @Override
    public List<Users> getAllUser() {
        return null;
    }
}