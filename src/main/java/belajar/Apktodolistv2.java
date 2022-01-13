package belajar;

import repository.TodolistRepository;
import repository.TodolistsRepositoryImpl;
import service.TodoListServiceIMPL;
import service.TodolistService;
import util.DatabaseUtil;
import view.TodoListView;

import javax.sql.DataSource;

public class Apktodolistv2 {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodolistRepository todolistRepository = new TodolistsRepositoryImpl(dataSource);
        TodolistService todolistService = new TodoListServiceIMPL(todolistRepository);
        TodoListView todoListView = new TodoListView(todolistService);

        todoListView.showTodolist();
    }
}
