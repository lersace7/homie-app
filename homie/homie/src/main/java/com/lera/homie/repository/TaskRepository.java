package com.lera.homie.repository;

import com.lera.homie.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public void save(Task task) {
        String sql = "INSERT INTO task (title, completed, board_id) VALUES (?, ?, ?)";
        jdbc.update(sql, task.getTitle(), task.isCompleted(), task.getBoardId());
    }

    public List<Task> findByBoardId(Long boardId) {
        String sql = "SELECT * FROM task WHERE board_id = ?";
        return jdbc.query(
                sql,
                new BeanPropertyRowMapper<>(Task.class),
                boardId
        );
    }

    public void updateCompleted(Long taskId, boolean completed) {
        String sql = "UPDATE task SET completed = ? WHERE id = ?";
        jdbc.update(sql, completed, taskId);
    }

    public void delete(Long taskId) {
        String sql = "DELETE FROM task WHERE id = ?";
        jdbc.update(sql, taskId);
    }
}
