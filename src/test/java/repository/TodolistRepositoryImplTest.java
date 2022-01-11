package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import util.DatabaseUtil;

public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;
    private TodolistRepository todolistRepository;

    @BeforeEach
    void setUp(){
        dataSource = DatabaseUtil.getDataSource();
        todolistRepository = new TodolistsRepositoryImpl(dataSource);
    }

    @Test
    public void testAdd(){
        Todolist todo = new Todolist();
        todo.setTodo("haaaaaa");
        System.out.println("isi todo: " + todo.getTodo());

        todolistRepository.add(todo);
    }

    @AfterEach
    void tearDown(){
        dataSource.close();
    }
}
