package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

import java.io.IOException;
import java.sql.Timestamp;

public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;
    private TodolistRepository todolistRepository;

    public void cl(){
//        tidak bekerja jika di dalam IDE.
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    @BeforeEach
    void setUp(){
        dataSource = DatabaseUtil.getDataSource();
        todolistRepository = new TodolistsRepositoryImpl(dataSource);
    }

    @Test
    public void testAdd(){
        Timestamp waktu = new Timestamp(System.currentTimeMillis());
        Todolist todo = new Todolist();
        todo.setTodo(waktu + " : haaaaaa");
//        System.out.println("isi todo: " + todo.getTodo());

        todolistRepository.add(todo);
    }

    @Test
    void testRemove(){
        System.out.println(todolistRepository.remove(12));
        System.out.println(todolistRepository.remove(14));
        System.out.println(todolistRepository.remove(15));
        System.out.println(todolistRepository.remove(19));
    }


    @Test
    void testGetAll() throws IOException {
        Todolist[] todolists = todolistRepository.getAll();
        for (var todo: todolists ) {
            System.out.println(todo.getId()+" : "+todo.getTodo());
        }
//            cl();
    }

    @AfterEach
    void tearDown(){
        dataSource.close();
    }
}
