package app.repository.implemantationH;

import app.config.HibernateConfig;
import app.domain.dto.PurchaseDto;
import app.domain.entity.Customer;
import app.domain.entity.Medicament;
import app.domain.entity.Purchase;
import app.repository.IRepository;
import app.repository.RepositoryKeyObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PurchaseRepositoryHibernate implements RepositoryKeyObject<Purchase, Customer>
{
    private HibernateConfig _hibernateConfig = new HibernateConfig();

//    @Autowired
//    public PurchaseRepositoryHibernate (HibernateConfig hibernateConfig)
//    {
//        _hibernateConfig = hibernateConfig;
//    }

    @Override
    public Purchase get(Integer id)
    {
        return _hibernateConfig.getSessionFactory().openSession().get(Purchase.class, id);
    }

    @Override
    public List<Purchase> getAll()
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        List<Purchase> l = IRepository.loadAllData(Purchase.class, session);
        session.close();
        return l;
    }

    @Override
    public void save(Purchase purchase)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(purchase);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Purchase purchase)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(purchase);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Purchase purchase)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(purchase);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Purchase> getAllBy(Customer customer)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        String hql = "from Purchase where customer_id = " + customer.getId().toString();
        Query query = session.createQuery(hql);

        List result = query.list();
        session.close();
        return result;
    }
}
