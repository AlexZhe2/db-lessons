package jpa.repository;

import jpa.entity.Group;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        /*TypedQuery<Group> query =
                manager.createNamedQuery("Group.getAll", Group.class);
        List<Group> groups = query.getResultList();*/

        /*2. JPQL */
        /*Query query = manager.createQuery("SELECT g FROM Group g");
        List<Group> groups = (List<Group>) query.getResultList();*/

        /*3. Criteria API*/
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery =
                criteriaBuilder.createQuery(Group.class);
        Root<Group> root = criteriaQuery.from(Group.class); // from Group
        criteriaQuery.select(root);

        TypedQuery<Group> typedQuery = manager.createQuery(criteriaQuery);
        List<Group> groups = typedQuery.getResultList();

        return groups;
    }

    public Group getGroupByName(String groupName){
        /*1. named query*/

    }


}
