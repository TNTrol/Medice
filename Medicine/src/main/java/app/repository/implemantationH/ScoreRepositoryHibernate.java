package app.repository.implemantationH;

import app.config.HibernateConfig;
import app.domain.dto.ScoreDto;
import app.domain.entity.Purchase;
import app.domain.entity.Score;
import app.repository.IRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ScoreRepositoryHibernate  implements IRepository<Score>
{

    private HibernateConfig _hibernateConfig  = new HibernateConfig();

//    @Autowired
//    public ScoreRepositoryHibernate(HibernateConfig hibernateConfig)
//    {
//        _hibernateConfig = hibernateConfig;
//    }
    @Override
    public Score get(Integer id)
    {
        return _hibernateConfig.getSessionFactory().openSession().get(Score.class, id);
    }

    @Override
    public List<Score> getAll()
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        List<Score> l = IRepository.loadAllData(Score.class, session);
        session.close();
        return l;
    }

    @Override
    public void save(Score score)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(score);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Score score)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(score);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Score score)
    {
        Session session = _hibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(score);
        transaction.commit();
        session.close();
    }
}
