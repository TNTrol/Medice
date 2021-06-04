package app.service;


import app.domain.dto.*;
import app.domain.entity.*;
import app.repository.IRepository;
import app.repository.RepositoryKeyObject;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class WarehouseService
{
    private RepositoryKeyObject<Product, Medicament> productRepository;
    private IRepository<Score> scoreRepository;
    private RepositoryKeyObject<Purchase, Customer> purchaseRepository;
    private IRepository<Customer> customerRepository;
    private IRepository<Medicament> medicamentRepository;
    private IRepository<Offer> offerRepository;

    @Autowired
    public WarehouseService(IRepository<Score> scoreRepository, RepositoryKeyObject<Purchase, Customer> purchaseRepository,
                            IRepository<Customer> customerRepository, IRepository<Medicament> medicamentRepository, IRepository<Offer> offerRepository,
                            RepositoryKeyObject<Product, Medicament> productRepository)
    {
        this.offerRepository = offerRepository;
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
        this.scoreRepository = scoreRepository;
        this.medicamentRepository = medicamentRepository;
        this.productRepository = productRepository;
    }

    private List<Score> buyProductByOffer(@NonNull Offer offer)
    {
        List<Score> scores = new LinkedList<>();
        List<Product> allProducts = productRepository.getAllBy(offer.getMedicament());
        int count = offer.getCount();
        for(Product product: allProducts)
        {
            if(count < product.getCount())
            {
                Score score = calculateScore(offer.getMedicament(), offer.getCustomer(), count, product.getDelay());
                scores.add(score);
                product.setCount(product.getCount() - count);
                productRepository.update(product);
                break;
            }
            else
            {
                Score score = calculateScore(offer.getMedicament(), offer.getCustomer(), product.getCount(), product.getDelay());
                scores.add(score);
                count -= product.getCount();
                productRepository.delete(product);
            }
        }
        return scores;
    }

    private Score calculateScore(@NonNull Medicament medicament, @NonNull Customer customer, @NonNull Integer count, @NonNull Integer delay)
    {

        Score score = new Score( 0d, 10, medicament, count, customer);/////customer
        Double price = count * medicament.getPrice();
        score.setCost( score.getCost() + (delay < 30 ? price/ 2 : price));
        return score;
    }

    private void revision()
    {
        List<Product> products = productRepository.getAll();
        List<Product> removeProduct = new LinkedList<>();
        for(Product product : products)
        {
            product.setDelay(product.getDelay() - 1);
            if(product.getDelay() <= 0)
            {
                removeProduct.add(product);
                continue;
            }
            productRepository.update(product);
        }
        for(Product product : removeProduct)
            productRepository.delete(product);
    }

    private void spendPurchaseToCustomer(Customer customer)
    {

        List<Purchase> purchases = purchaseRepository.getAllBy(customer);
        for(Purchase purchase: purchases)
        {
            purchase.setDelay(purchase.getDelay() - 1);
            if(purchase.getDelay() <= 0) {
                Offer offer = new Offer(customer, null, purchase.getCount(), purchase.getMedicament());
                offerRepository.save(offer);

                //customer.getOffers().add(offer);
                List<Score> scores = buyProductByOffer(offer);

                for(Score score : scores) {
                    scoreRepository.save(score);
                }
                //System.out.println(customer);
                purchase.setDelay(purchase.getTimeDelay());
            }
           purchaseRepository.update(purchase);
        }
    }

    private void periodic()
    {
        for(Customer customer : customerRepository.getAll())
            spendPurchaseToCustomer(customer);
    }

    public void update()
    {
        periodic();
        revision();
    }

    public List<Score> buy(Customer customer, Medicament medicament, int count)
    {
        Offer offer = new Offer(customer, null, count, medicament);
        offerRepository.save(offer);
        List<Score> scores = buyProductByOffer(offer);
        for(Score score: scores)
            scoreRepository.save(score);
        return scores;
    }
}
