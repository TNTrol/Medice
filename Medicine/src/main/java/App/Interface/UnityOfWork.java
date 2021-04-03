package App.Interface;

import App.Models.*;

public interface UnityOfWork
{
    DaoKeyObject<Product, Medicament> getProductRepository();
    Dao<Purchase> getPurchaseRepository();
    Dao<Customer> getCustomerRepository();
    Dao<Score> getScoreRepository();
    Dao<Medicament> getMedicamentRepository();
}
