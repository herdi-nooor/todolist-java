package repository;

import entity.Todolist;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodolistsRepositoryImpl implements TodolistRepository{

    private Todolist[] data = new Todolist[10];
    private DataSource dataSource;
    public TodolistsRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Todolist todolist) {
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
//        lebih baik nanti di ganti typedata method nya menjadi List<>.
        String sql = "SELECT id, todo FROM todolist";
        try (Connection cn = dataSource.getConnection();
             Statement statement = cn.createStatement();
             ResultSet result = statement.executeQuery(sql)){
            List<Todolist> list = new ArrayList<>();
            while (result.next()){
                Todolist todolist = new Todolist();
                todolist.setId(result.getInt("id"));
                todolist.setTodo(result.getString("todo"));

                list.add(todolist);
            }

            return list.toArray(new Todolist[0]);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isExists(Integer number){
        String sql = "SELECT id FROM todolist WHERE id = ?";
        try (Connection cn = dataSource.getConnection();
             PreparedStatement statement = cn.prepareStatement(sql)) {
                statement.setInt(1, number);

                try (ResultSet result = statement.executeQuery()){
                    if (result.next()){
                        return true;
                    }else {
                        return false;
                    }
                }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean remove(Integer number) {
        if (isExists(number)){
            String sql = "DELETE FROM todolist WHERE id = ?";
            try (Connection cn = dataSource.getConnection();
                PreparedStatement statement = cn.prepareStatement(sql)) {
                    statement.setInt(1, number);
                    statement.executeUpdate();
                    return true;
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }else {
            return false;
        }

    }
}
