package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.util.JPAHelper;
import jakarta.persistence.EntityManager;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
@ApplicationScoped
public class TeacherDAOImpl implements ITeacherDAO{
    @Override
    public Teacher insert(Teacher teacher) {
        EntityManager em = getEntityManager();
        em.persist(teacher);
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {
        getEntityManager().merge(teacher);
        return teacher;
    }

    @Override
    public void delete(Long id) {
        EntityManager em = getEntityManager();
        Teacher teacherToDelete = em.find(Teacher.class, id);
        em.remove(teacherToDelete);
    }

    @Override
    public List<Teacher> getByLastname(String lastname) {
        return null;
    }

    @Override
    public Teacher getById(Long id) {
        EntityManager em = getEntityManager();
        return em.find(Teacher.class, id);
    }

    private EntityManager getEntityManager() {
        return JPAHelper.getEntityManager();
    }
}
