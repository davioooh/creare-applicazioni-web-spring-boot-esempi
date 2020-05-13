package com.davioooh.superrubrica.stats;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserStatsRepository {
    private JdbcTemplate jdbcTemplate;

    public UserStatsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<UserStats> findAllStats() {
        return jdbcTemplate.query(
                "select owner_username as username, count(*) as contacts_count" +
                        " from contacts group by owner_username ",
                new UserStatsRowMapper()
        );
    }

    static class UserStatsRowMapper extends BeanPropertyRowMapper<UserStats> {
        public UserStatsRowMapper() {
            super(UserStats.class);
        }
    }

}

