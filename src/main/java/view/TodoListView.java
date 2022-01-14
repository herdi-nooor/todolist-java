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
            System.out.print("\033[H\033[2J");
            System.out.println("TODO LIST");
            todolistService.showTodoList();
            System.out.println("Menu : ");
            System.out.println("\t( 1 )-> tambah");
            System.out.println("\t( 2 )-> hapus");
            System.out.println("\t( x )-> keluar");
            var input = IntputUtil.input("Pilih  ");
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
                    IntputUtil.input("\tenter untuk lanjut");
                    break;
            }
        }
    }
    public void addTodolist(){
        System.out.println("MENAMBAH DATA");
        var todo = IntputUtil.input("ketikan ( x ) untuk batal");
        if (todo.equals("x")){
            System.out.println("anda membatalkanya");
            IntputUtil.input("\tenter untuk lanjut");
        }else{
            todolistService.addTodoList(todo);
            IntputUtil.input("\tenter untuk lanjut");
        }
    }
    public void removeTodolist(){
        System.out.println("MENGHAPUS DATA");
        var index = IntputUtil.input("masukan index data yang akan di hapus \nketikan ( x ) untuk batal");
        if (index.equals("x")) {
            System.out.println("anda membatalkanya");
            IntputUtil.input("\tenter untuk lanjut");
        } else if (IntputUtil.isString(index)) {
            System.out.println("hanya input angka, janga yang lain");
            IntputUtil.input("\n\tenter untuk lanjut");
        }else{
            todolistService.removeTodoList(Integer.valueOf(index));
            IntputUtil.input("\tenter untuk lanjut");
        }
    }


}
