package com.davioooh.superrubrica.contact;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Optional;

@Repository
public class ContactRepository {
    private JdbcTemplate jdbcTemplate;

    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Contact> findById(long id) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            "select * from contacts where id = ?",
                            new ContactRowMapper(),
                            id
                    )
            );
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    public Contact create(Contact contact) {
        String sql = "insert into contacts (first_name, last_name, phone, email) values (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getPhone());
            preparedStatement.setString(4, contact.getEmail());
            return preparedStatement;
        }, keyHolder);

        String keyAsString = keyHolder.getKeys().get("id").toString();
        contact.setId(Long.parseLong(keyAsString));
        return contact;
    }

    static class ContactRowMapper extends BeanPropertyRowMapper<Contact> {
        public ContactRowMapper() {
            super(Contact.class);
        }
    }

}