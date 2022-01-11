package repository;

import entity.Todolist;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodolistsRepositoryImpl implements TodolistRepository{

    private Todolist[] data = new Todolist[10];
    private DataSource dataSource;
    public TodolistsRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Todolist todolist) {
        System.out.println("add : " + todolist.getTodo());
        String sql = "INSERT INTO todolist(todo) VALUES (?)";
        try (Connection cn = dataSource.getConnection()){
            try(PreparedStatement statement = cn.prepareStatement(sql)) {
                statement.setString(1, todolist.getTodo());
                statement.executeUpdate();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Todolist[] getAll() {
        return data;
    }
    public boolean isFull(){
        //        cek penuh atau tidak
        var penuh = true;
        for (int i = 0; i < data.length; i++){
            if (data[i] == null){
                penuh = false;
                break;
            }
        }
        return penuh;
    }
    public void resizeIfFull(){
        //        jika data penuh
        if(isFull()){
            var temp = data;
        //        melipat gandakan ukuran array dan memindahkan data
            data = new Todolist[data.length + 10];
            for (int i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        number--;
        if (number>= data.length){
            System.out.println("\t----------------------------------------\n\t| index yang diberikan melebihi jumlah | \n\t| penampungan data yang ada \t\t   |\n\t----------------------------------------\n");
            return false;
        }else if (data[number] == null){
            System.out.println("\t----------------------------\n\t|tidak ada data di index " + (number+1) + " |\n\t----------------------------\n");
            return false;
        }else{
            for (int i = number; i < data.length; i++){
                if (i == (data.length -1)){
                    data[i] = null;
                }else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
