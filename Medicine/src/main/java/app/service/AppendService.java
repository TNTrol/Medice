package app.service;

import app.domain.dto.*;
import app.domain.entity.*;
import app.repository.IRepository;
import app.repository.RepositoryKeyObject;
import app.repository.implemantationH.MedicamentRepositoryHibernate;
import app.repository.implemantationH.ProductRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class AppendService
{
    @Autowired
    private RepositoryKeyObject<Product, Medicament> productRepository;
    @Autowired
    private IRepository<Score> scoreRepository;
    @Autowired
    private IRepository<Purchase> purchaseRepository;
    @Autowired
    private IRepository<Customer> customerRepository;
    @Autowired
    private IRepository<Medicament> medicamentRepository;

    public void addMedicament(List<Product> products)
    {
        for (Product product : products)
            productRepository.save(product);
    }

    public void generateProduction()
    {
        List<Medicament> medicaments = medicamentRepository.getAll();
        Product product = new Product();
        product.setCount(400);
        product.setMedicament(medicaments.get(0));
        product.setDelay(340);
        productRepository.save(product);
        product = new Product();
        product.setDelay(100);
        product.setMedicament(medicaments.get(3));
        product.setCount(200);
        productRepository.save(product);
        product = new Product();
        product.setMedicament(medicaments.get(1));
        product.setCount(124);
        product.setDelay(300);
        productRepository.save(product);
        product = new Product();
        product.setCount(400);
        product.setMedicament(medicaments.get(2));
        product.setDelay(450);
        productRepository.save(product);
    }
}
