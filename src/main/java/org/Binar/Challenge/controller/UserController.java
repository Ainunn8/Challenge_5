package org.Binar.Challenge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.model.Product;
import org.Binar.Challenge.model.Users;
import org.Binar.Challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
@Slf4j

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Api to get all user")
    public List<Users> getUser() {
        return userService.getAllUser();
    }

    // Menambahkan User Baru
    @PostMapping("/add-user")
    public ResponseEntity addUsers(@RequestBody Users users) {
        userService.addUsers(Users.builder()
                .id(users.getId())
                .username(users.getUsername())
                .email(users.getEmail())
                .password(users.getPassword())
                .build());

        return ResponseEntity.ok("Add new user successful!");
    }

    // Mengupdate User

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{userid}")
    public String updateUsers(@RequestParam("newUserid") String newUserid,
                              @PathVariable("oldUserid") String oldUserid,
                              @RequestHeader("Accept-Languange") String acceptLanguage,
                              @RequestBody Users users) {
        log.info("Accept-Language - {}", acceptLanguage);
        userService.updateUsers(oldUserid,newUserid );
        return "update movie successful!";
    }

    // Menghapus User

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{userid}")
    public String deleteMovie(@PathVariable("userid") String userid) {
        userService.deleteUsers(userid);
        return "Delete user " + userid + " success!";
    }

    @GetMapping(value = "/detail")
    @Operation(summary = "Getting detail of one User by product code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found"),
            @ApiResponse(responseCode = "404", description = "Inputted product code not found")
    })


    private List<?> testWildCard(){
        return Arrays.asList("String", 40);
    }

}
