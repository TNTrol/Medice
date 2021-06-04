package app.repository.implemantationH;

import app.config.HibernateConfig;
import app.domain.dto.MedicamentDto;
import app.domain.dto.TypeMedicament;
import app.domain.entity.Customer;
import app.domain.entity.Medicament;
import app.repository.IRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class MedicamentRepositoryHibernate implements IRepository<Medicament>
{
    private final HibernateConfig _hibernateConfig = new HibernateConfig();

//    @Autowired
//    public MedicamentRepositoryHibernate (HibernateConfig hibernateConfig)
//    {
//        _hibernateConfig = hibernateConfig;
//    }


    @Override
    public Medicament get(Integer id)
    {
        return _hibernateConfig.getSessionFactory().openSession().get(Medicament.class, id);
    }

    @Override
    public List<Medicament> getAll()
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        List<Medicament> l = IRepository.loadAllData(Medicament.class, session);
        session.close();
        return l;
    }

    @Override
    public void save(Medicament medicament)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(medicament);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Medicament medicament)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(medicament);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Medicament medicament)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(medicament);
        transaction.commit();
        session.close();
    }
}
