package com.davioooh.superrubrica.user;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<User> findByUsername(String username) {
        try {
            User user = jdbcTemplate.queryForObject(
                    "select * from users where username = ?",
                    new UserRowMapper(),
                    username
            );

            user.setRoles(findUserRoles(user.getId()));

            return Optional.ofNullable(user);
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    private Collection<String> findUserRoles(long userId) {
        return jdbcTemplate.queryForList(
                "select role from user_roles where user_id = ?",
                String.class,
                userId
        );
    }

    static class UserRowMapper extends BeanPropertyRowMapper<User> {
        public UserRowMapper() {
            super(User.class);
        }
    }

}
