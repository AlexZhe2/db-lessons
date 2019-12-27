package dao;

import pool.C3PODataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookDao implements Dao<Book, Integer> {

    @Override
    public List<Book> getAll() throws SQLException {
        String selectAll = "SELECT * FROM book;";
        try (Statement st = C3PODataSource.getConnection().createStatement())
        {

        }


        return null;
    }

    @Override
    public Book getByPK(Integer primaryKey) {
        return null;
    }

    @Override
    public boolean deleteByPK(Integer primaryKey) {
        return false;
    }

    @Override
    public Book add(Book entity) {
        return null;
    }

    @Override
    public Book update(Book entity) {
        return null;
    }
}
