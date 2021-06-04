package app.repository.implemantationH;

import app.config.HibernateConfig;
import app.domain.dto.OfferDto;
import app.domain.entity.Customer;
import app.domain.entity.Offer;
import app.repository.IRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OfferRepositoryHibernate implements IRepository<Offer>
{

    private  HibernateConfig _hibernateConfig  = new HibernateConfig();

//    @Autowired
//    public OfferRepositoryHibernate (HibernateConfig hibernateConfig)
//    {
//        _hibernateConfig = hibernateConfig;
//    }

    @Override
    public Offer get(Integer id)
    {
        return _hibernateConfig.getSessionFactory().openSession().get(Offer.class, id);
    }

    @Override
    public List<Offer> getAll()
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        List<Offer> l = IRepository.loadAllData(Offer.class, session);
        session.close();
        return l;
    }

    @Override
    public void save(Offer offer)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(offer);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Offer offer)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(offer);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Offer offer)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(offer);
        transaction.commit();
        session.close();
    }
}
