package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodoListServiceIMPL implements TodolistService {

    private TodolistRepository todolistRepository;

    public TodoListServiceIMPL(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }


    @Override
    public void showTodoList() {
        Todolist[] model = todolistRepository.getAll();
        System.out.println("=====  TODO LIST =====");
        for (var todolist : model){
            System.out.println(todolist.getId()+". "+todolist.getTodo());
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("SUKSES MENAMBAHKAN TODOLIST");
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todolistRepository.remove(number);
        if (success){
            System.out.println("SUKSES MANGHAPUS DATA KE : " + number);
        }else {
            System.out.println("GAGAL MENGHAPUS DATA KE : " + number);
        }
    }
}
