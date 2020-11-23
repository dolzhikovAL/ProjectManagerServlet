package com.project.management.domainDAO;

import com.project.management.database.HibernateDataBaseConnector;
import com.project.management.domain.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class CompanyDAO extends DataCRUD<Company> {
    private final static Logger LOG = LogManager.getLogger(CompanyDAO.class);
    private SessionFactory sessionFactory;

    public CompanyDAO() {
        sessionFactory = HibernateDataBaseConnector.getSessionFactory();
    }

    @Override
    public void create(Company company) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOG.debug(String.format("Creating company: %s", company.getName()));
        session.save(company);
        transaction.commit();
        session.close();
        LOG.debug(String.format("Company created: %s", company.getName()));
    }

    @Override
    public Company read(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOG.debug(String.format("Finding company by id: %s", id));
        Company company = session.get(Company.class, id);
        transaction.commit();
        session.close();
        LOG.debug(String.format("Company found: %s", company));
        return company;
    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void delete(Company company) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOG.debug(String.format("Deleting company: %s", company.getName()));
        session.delete(company);
        LOG.debug(String.format("Company deleted: %s", company.getName()));
        transaction.commit();
        session.close();
        LOG.debug(String.format("Company deleted: %s", company.getName()));
    }

    public Company findByName(String name) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOG.debug(String.format("Finding company, name = %s", name));
        Query query2 = session.createQuery("from Company as c where c.name=:name");
        Company result;
        try {
            result = (Company) query2.setParameter("name", name).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new NullPointerException("Company with the name provided does not exist in database");
        }
        session.close();
        LOG.debug(String.format("Company found: %s", result));
        return result;
    }

    public List<Company> getAll() {
        LOG.debug("Generating All companies list");
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Company").getResultList();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;

        }
    }
}
