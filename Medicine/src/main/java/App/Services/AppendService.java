package App.Services;

import App.Interface.Dao;
import App.Interface.DaoKeyObject;
import App.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppendService
{
    @Autowired
    private DaoKeyObject<Product, Medicament> productRepository;
    @Autowired
    private Dao<Score> scoreRepository;
    @Autowired
    private Dao<Purchase> purchaseRepository;
    @Autowired
    private Dao<Customer> customerRepository;
    @Autowired
    private  Dao<Medicament> medicamentRepository;

    public void testData()
    {
        List<Customer> customers = customerRepository.getAll();
        List<Medicament> medicaments = medicamentRepository.getAll();

        purchaseRepository.save(new Purchase(medicaments.get(0), 20, 10));
        purchaseRepository.save(new Purchase(medicaments.get(2), 10, 10));
        purchaseRepository.save(new Purchase(medicaments.get(1), 7, 12));
        purchaseRepository.save(new Purchase(medicaments.get(3), 5, 12));
        purchaseRepository.save(new Purchase(medicaments.get(0), 12, 9));

        List<Purchase> purchases = purchaseRepository.getAll();
        customers.get(0).getPurchases().add(purchases.get(0));
        customers.get(0).getPurchases().add(purchases.get(1));
        customers.get(1).getPurchases().add(purchases.get(2));
        customers.get(1).getPurchases().add(purchases.get(3));
        customers.get(1).getPurchases().add(purchases.get(4));

        productRepository.save(new Product(medicaments.get(0), 120, 500));
        productRepository.save(new Product(medicaments.get(1), 90, 300));
        productRepository.save(new Product(medicaments.get(3), 135, 250));
        productRepository.save(new Product(medicaments.get(2), 145, 450));
    }

    public void addMedicament(List<Product> products)
    {
        for (Product product : products)
            productRepository.save(product);
    }
}
