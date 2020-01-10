package jpa.repository;

import jpa.entity.Group;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GroupRepository implements Repository<Group, Integer> {
    private EntityManager manager;

    public GroupRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Group group) {
        manager.persist(group); // добавление записи в таблицу
    }

    @Override
    public void update(Group group) {
        manager.merge(group); // обновление существующей записи
    }

    @Override
    public void delete(Integer integer) {
        manager.getTransaction().begin();
        Group group = getByPk(integer);
        manager.remove(group); // удаление объекта
        manager.getTransaction().commit();
    }

    @Override
    public Group getByPk(Integer integer) {
        // получение записи по первичному ключу
        return manager.find(Group.class, integer);
    }

    @Override
    public List<Group> getAll() {
        /*1. named queries*/
        TypedQuery<Group> query =
                manager.createNamedQuery("Group.getAll", Group.class);
        List<Group> groups = query.getResultList();

        return groups;
    }
}
