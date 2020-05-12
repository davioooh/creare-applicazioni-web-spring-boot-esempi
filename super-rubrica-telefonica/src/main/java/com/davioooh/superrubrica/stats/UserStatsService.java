package com.davioooh.superrubrica.stats;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserStatsService {
    private UserStatsRepository userStatsRepository;

    public UserStatsService(UserStatsRepository userStatsRepository) {
        this.userStatsRepository = userStatsRepository;
    }

    public Collection<UserStats> getStats() {
        return userStatsRepository.findAllStats();
    }

}
