package App.Repository;

import App.Interface.Dao;
import App.Interface.DaoKeyObject;
import App.Interface.UnityOfWork;
import App.Models.*;
import App.Repository.*;
import org.springframework.stereotype.Repository;

public class UnityOfWorkImpl implements UnityOfWork
{

    private ProductRepositoryDAO productRepository;
    private PurchaseRepositoryDAO purchaseRepositoryDAO;
    private ScoreRepositoryDAO scoreRepositoryDAO;
    private CustomerRepositoryDAO customerRepositoryDAO;
    private MedicamentRepositoryDAO medicamentRepositoryDAO;

    public UnityOfWorkImpl()
    {
        productRepository = new ProductRepositoryDAO();
        purchaseRepositoryDAO = new PurchaseRepositoryDAO();
        scoreRepositoryDAO = new ScoreRepositoryDAO();
        customerRepositoryDAO = new CustomerRepositoryDAO();
        medicamentRepositoryDAO = new MedicamentRepositoryDAO();
    }

    @Override
    public DaoKeyObject<Product, Medicament> getProductRepository()
    {
        return productRepository;
    }

    @Override
    public Dao<Purchase> getPurchaseRepository()
    {
        return purchaseRepositoryDAO;
    }

    @Override
    public Dao<Customer> getCustomerRepository()
    {
        return customerRepositoryDAO;
    }

    @Override
    public Dao<Score> getScoreRepository()
    {
        return scoreRepositoryDAO;
    }

    @Override
    public Dao<Medicament> getMedicamentRepository()
    {
        return medicamentRepositoryDAO;
    }
}
