package org.globaldev.services.impl;

import org.globaldev.domain.UserTwo;
import org.globaldev.services.UserRepositoryFake;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryFakeImpl implements UserRepositoryFake {

    private List<UserTwo> userList;

    public UserRepositoryFakeImpl() {

        this.userList = new ArrayList<>();

        List<String> roles = new ArrayList<>();
        roles.add("USER");

        UserTwo user = new UserTwo();

        user.setUsername("user");
        user.setPassword("123456");
        user.setRoles(roles);

        this.userList.add(user);

        user = new UserTwo();

        user.setUsername("admin");
        user.setPassword("123456");
        roles.add("ADMIN");
        user.setRoles(roles);
    }

    @Override
    public UserTwo findByUsername(String username) {
        List<UserTwo> result = this.userList.stream().filter(user -> user.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());

        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }


    }
}
