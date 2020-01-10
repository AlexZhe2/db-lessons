package jpa.tst;

import jpa.entity.Group;
import jpa.repository.GroupRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TstRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("ormLesson");
        EntityManager manager = factory.createEntityManager();

        GroupRepository groupRepository = new GroupRepository(manager);

        Group jjd = new Group("JJD", 3, 20000);
        Group python = new Group("Python", 2, 15000);
        Group nodeJS = new Group("Node JS", 3, 15000);
        Group web = new Group("Web Developer", 4, 25000);

        manager.getTransaction().begin();
        groupRepository.add(jjd);
        groupRepository.add(python);
        groupRepository.add(nodeJS);
        groupRepository.add(web);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
