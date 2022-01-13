package view;

import service.TodolistService;
import util.IntputUtil;

public class TodoListView {
    
    private TodolistService todolistService;

    public TodoListView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodolist(){
        boolean ulang = true;
        while (ulang) {
            cl();
            System.out.println("TODO LIST");
            todolistService.showTodoList();
            System.out.println("Menu : ");
            System.out.println("\t( 1 )-> tambah");
            System.out.println("\t( 2 )-> hapus");
            System.out.println("\t( x )-> keluar");
            var input = IntputUtil.input("Pilih");
            switch (input) {
                case "1":
                    addTodolist();
                    break;
                case "2":
                    removeTodolist();
                    break;
                case "x":
                    ulang = false;
                    break;
                default:
                    System.out.println(" pilihan tidak di mengwerti ");
                    break;
            }
        }
    }
    public void addTodolist(){
        System.out.println("MENAMBAH DATA");
        var todo = IntputUtil.input("ketikan ( x ) untuk batal");
        if (todo.equals("x")){
            System.out.println("anda membatalkanya");
            IntputUtil.input("enter untuk lanjut");
        }else{
            todolistService.addTodoList(todo);
        }
    }
    public void removeTodolist(){
        System.out.println("MENGHAPUS DATA");
        var index = IntputUtil.input("masukan index data yang akan di hapus \n" +
                "ketikan ( x ) untuk batal \n\t");
        if (index.equals("x")) {
        } else {
            todolistService.removeTodoList(Integer.valueOf(index));
        }
    }

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

}
