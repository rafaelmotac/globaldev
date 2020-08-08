package org.globaldev.services;

import org.globaldev.domain.UserTwo;

import java.util.Optional;

public interface UserRepositoryFake {

    UserTwo findByUsername(String username);
}
