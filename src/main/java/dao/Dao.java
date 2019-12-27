package dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T, PK> {
    // T - тип данных
    // PK - тип данных первичного ключа

    List<T> getAll() throws SQLException; // получение всех записей из бд
    // получение одной записи по первичному ключу
    T getByPK(PK primaryKey);
    // удаление по первичному ключу
    boolean deleteByPK(PK primaryKey);
    // добавление в базу данных
    T add(T entity);
    // обновление данных в базе
    T update(T entity);
}
