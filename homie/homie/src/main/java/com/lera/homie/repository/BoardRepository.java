package com.lera.homie.repository;

import com.lera.homie.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(Board board) {
        String sql = "INSERT INTO board (name, circle_id) VALUES (?, ?)";
        jdbc.update(sql, board.getName(), board.getCircleId());
    }

    public List<Board> findByCircleId(Long circleId) {
        String sql = "SELECT * FROM board WHERE circle_id = ?";
        return jdbc.query(
                sql,
                new BeanPropertyRowMapper<>(Board.class),
                circleId
        );
    }
}
