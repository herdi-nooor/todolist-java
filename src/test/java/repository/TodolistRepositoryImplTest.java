package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

import java.sql.Timestamp;

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
        Timestamp waktu = new Timestamp(System.currentTimeMillis());
        Todolist todo = new Todolist();
        todo.setTodo(waktu + ": data ini ditambahkan ketika test jalan");
        todolistRepository.add(todo);
    }

//    @Test
//    void testGetAll(){
//        Todolist[] todolists = todolistRepository.getAll();
//        for (var todo: todolists ) {
//            System.out.println(todo.getId()+" : "+todo.getTodo());
//        }
//    }

    @AfterEach
    void tearDown(){
        dataSource.close();
    }
}
