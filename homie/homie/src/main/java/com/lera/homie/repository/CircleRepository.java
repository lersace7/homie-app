package com.lera.homie.repository;

import com.lera.homie.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class CircleRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(Circle circle) {

        String sql = "INSERT INTO circle (name) VALUES (?)";

        jdbc.update(sql, circle.getName());
    }

    public List<Circle> findAll() {

        String sql = "SELECT * FROM circle";

        return jdbc.query(
                sql,
                new BeanPropertyRowMapper<>(Circle.class)
        );
    }

}
