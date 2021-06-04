package app.config;

import app.domain.dto.*;
import app.domain.entity.*;
import app.repository.IRepository;
import app.repository.RepositoryKeyObject;

import app.repository.implemantationH.*;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{

    public HibernateConfig hibernateConfig()
    {
        return new HibernateConfig();
    }

//    public IRepository<Score> scoreRepository()
//    {
//        return new ScoreRepositoryHibernate(hibernateConfig);
//    }
//
//    public IRepository<Purchase> purchaseRepository()
//    {
//        return new PurchaseRepositoryHibernate(hibernateConfig);
//    }
//
//    public IRepository<Customer> customerRepository()
//    {
//        return new CustomerRepositoryHibernate(hibernateConfig);
//    }
//
//    public RepositoryKeyObject<Product, Medicament> productRepository()
//    {
//        return new ProductRepositoryHibernate(hibernateConfig);
//    }
//
//    public IRepository<Medicament> medicamentRepository()
//    {
//        return new MedicamentRepositoryHibernate(hibernateConfig);
//    }

}
