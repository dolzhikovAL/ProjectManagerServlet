package com.project.management.domainDAO;

import com.project.management.database.HibernateDataBaseConnector;
import com.project.management.domain.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class ProjectDAO extends DataCRUD<Project> {
    private final static Logger LOG = LogManager.getLogger(CustomerDAO.class);
    private SessionFactory sessionFactory;

    public ProjectDAO() {
        sessionFactory = HibernateDataBaseConnector.getSessionFactory();
    }

    @Override
    public void create(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOG.debug(String.format("Creating project: %s", project.getName()));
        session.save(project);
        transaction.commit();
        LOG.debug(String.format("Project created: %s", project.getName()));
        session.close();
    }

    @Override
    public Project read(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOG.debug(String.format("Finding project by id: %s", id));
        Project project = session.get(Project.class, id);
        transaction.commit();
        session.close();
        LOG.debug(String.format("Project: %s", project));
        return project;
    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOG.debug(String.format("Deleting project: %s", project.getName()));
        session.delete(project);
        transaction.commit();
        LOG.debug(String.format("Project deleted: %s", project.getName()));
        session.close();
    }

    public Project findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOG.debug(String.format("Finding Project, name = %s", name));
        Query query = session.createQuery("from Project p where p.name = :name");
        Project result;
        try {result = (Project) query.setParameter("name", name).uniqueResult();
            transaction.commit();}
        catch (Exception e) {
            LOG.error(e.getMessage());
            throw new NullPointerException("Project with the phone number provided does not exist in database");
        }
        session.close();
        return result;
    }

    public List<Project> getAll() {
        try (Session session = sessionFactory.openSession()) {
            LOG.debug("Generating All projects list");
            return session.createQuery("FROM Project").getResultList();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
    }
}


