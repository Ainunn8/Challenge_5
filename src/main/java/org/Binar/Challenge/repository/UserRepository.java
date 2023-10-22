package org.Binar.Challenge.repository;

import org.Binar.Challenge.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, String> {

    @Query(nativeQuery = true, value = "delete from user where id = :userId")
    void deleteUsers(@Param("userId") String id);

    @Query(nativeQuery = true, value = "update user set id = :newUserid where id = :oldUserid")
    void editUser(@Param("oldserid") String oldUserid, @Param("newUserid") String newUserid);

}
