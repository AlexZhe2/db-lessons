package jpa.repository;

import jpa.entity.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentRepository implements Repository<Student, Integer> {
    private EntityManager manager;

    public StudentRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Student student) {
        manager.persist(student);
    }

    @Override
    public void update(Student student) {
        manager.merge(student);
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Student getByPk(Integer integer) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
