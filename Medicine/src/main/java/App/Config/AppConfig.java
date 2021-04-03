package App.Config;

import App.Interface.Dao;
import App.Interface.DaoKeyObject;
import App.Models.*;
import App.Repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public Dao<Score> scoreRepository()
    {
        return new ScoreRepositoryDAO();
    }

    @Bean
    public Dao<Purchase> purchaseRepository()
    {
        return new PurchaseRepositoryDAO();
    }

    @Bean
    public Dao<Customer> customerRepository()
    {
        return new CustomerRepositoryDAO();
    }

    @Bean
    public DaoKeyObject<Product, Medicament> productRepository()
    {
        return new ProductRepositoryDAO();
    }

    @Bean
    public Dao<Medicament> medicamentRepository()
    {
        return new MedicamentRepositoryDAO();
    }

}
