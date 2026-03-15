package com.lera.homie.repository;

import com.lera.homie.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Usuario findByEmail(String email) {

        String sql = "SELECT * FROM usuario WHERE email = ?";

        return jdbc.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Usuario.class),
                email
        );
    }

}
