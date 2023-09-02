package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.model.Teacher;

import java.util.List;

public interface ITeacherDAO {
    /**
     * Inserts a teacher to the database.
     *
     * @param teacher
     *              the inserted teacher.
     * @return
     *              the inserted teacher.
     */
    Teacher insert(Teacher teacher);

    /**
     *  Updates a teacher from the database.
     * @param teacher
     *              the teacher to be updated.
     * @return
     *              the updated teacher.
     */
    Teacher update(Teacher teacher);

    /**
     * Deletes a teacher from the database.
     * @param id
     *              the id of the teacher to be deleted.
     */
    void delete(Long id);

    /**
     * Returns a list of teachers by lastname.
     * @param lastname
     *              the given lastname.
     * @return
     *              the list of teachers.
     */
    List<Teacher> getByLastname(String lastname);

    /**
     * Gets a teacher from database by id.
     * @param id
     *              the given id.
     * @return
     *              the selected teacher.
     */
    Teacher getById(Long id);
}
