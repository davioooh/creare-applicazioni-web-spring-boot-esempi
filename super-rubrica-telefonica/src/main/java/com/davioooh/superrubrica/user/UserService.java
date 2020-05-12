package com.davioooh.superrubrica.user;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class UserService {
    public Collection<UserStats> getUserStats() {
        return Arrays.asList(new UserStats("Tizio", 3), new UserStats("Caio", 10));
    }
}
