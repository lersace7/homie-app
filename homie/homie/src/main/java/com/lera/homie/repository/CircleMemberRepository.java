package com.lera.homie.repository;

import com.lera.homie.model.CircleMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CircleMemberRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public void addUserToCircle(Long userId, Long circleId) {

        String sql = "INSERT INTO circle_member (user_id, circle_id) VALUES (?, ?)";

        jdbc.update(sql, userId, circleId);
    }
}
