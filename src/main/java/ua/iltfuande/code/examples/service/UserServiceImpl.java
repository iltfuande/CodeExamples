package ua.iltfuande.code.examples.service;

import org.springframework.stereotype.Service;
import ua.iltfuande.code.examples.annotation.Loggable;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Loggable
    public String createUser(String username) {
        return username;
    }

    public String updateUser(String username) {
        return username + UUID.randomUUID();
    }
}
