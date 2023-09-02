package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.util.JPAHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
@ApplicationScoped
public class TeacherDAOImpl implements ITeacherDAO{
    /**
     * Inserts a teacher to the database.
     * @param teacher
     *              the inserted teacher.
     * @return
     *              the inserted teacher.
     */
    @Override
    public Teacher insert(Teacher teacher) {
        EntityManager em = getEntityManager();
        em.persist(teacher);
        return teacher;
    }

    /**
     * Updates a teacher from database.
     * @param teacher
     *              the teacher to be updated.
     * @return
     *              the updated teacher.
     */
    @Override
    public Teacher update(Teacher teacher) {
        getEntityManager().merge(teacher);
        return teacher;
    }

    /**
     * Deletes a teacher from the database.
     * @param id
     *              the id of the teacher to be deleted.
     */
    @Override
    public void delete(Long id) {
        EntityManager em = getEntityManager();
        Teacher teacherToDelete = em.find(Teacher.class, id);
        em.remove(teacherToDelete);
    }

    /**
     * Returns a list of teachers by lastname.
     * @param lastname
     *              the given lastname.
     * @return
     *              the list of teachers.
     */
    @Override
    public List<Teacher> getByLastname(String lastname) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Teacher> selectQuery = builder.createQuery(Teacher.class);
        Root<Teacher> root = selectQuery.from(Teacher.class);
        ParameterExpression<String> tLastname = builder.parameter(String.class);
        selectQuery.select(root).where(builder.like(root.get("lastname"),tLastname));

        TypedQuery<Teacher> query = getEntityManager().createQuery(selectQuery);
        query.setParameter(tLastname, lastname + "%");
        return query.getResultList();
    }

    /**
     * Gets a teacher from database by id.
     * @param id
     *              the given id.
     * @return
     *              the selected teacher.
     */
    @Override
    public Teacher getById(Long id) {
        EntityManager em = getEntityManager();
        return em.find(Teacher.class, id);
    }

    private EntityManager getEntityManager() {
        return JPAHelper.getEntityManager();
    }
}
