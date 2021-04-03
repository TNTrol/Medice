package App.Services;


import App.Interface.Dao;
import App.Interface.DaoKeyObject;
import App.Interface.UnityOfWork;
import App.Models.*;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class Warehouse
{

    @Autowired
    private DaoKeyObject<Product, Medicament> productRepository;
    @Autowired
    private Dao<Score> scoreRepository;
    @Autowired
    private Dao<Purchase> purchaseRepository;
    @Autowired
    private Dao<Customer> customerRepository;


    public Warehouse()
    {

    }

    public List<Score> buyProductByOffer(@NonNull Offer offer)
    {
        List<Score> scores = new LinkedList<>();
        List<Product> allProducts = productRepository.getAllBy(offer.getMedicament());
        int count = offer.getCount();
        for(Product product: allProducts)
        {
            if(count < product.getCount())
            {
                Score score = calculateScore(offer.getMedicament(), offer.getCustomer(), count, product.getDelay());
                //unityOfWork.getScoreRepository().save( score);
                scores.add(score);
                offer.getCustomer().getScores().add(score);
                product.setCount(product.getCount() - count);
                productRepository.update(product);
                break;
            }
            else
            {
                Score score = calculateScore(offer.getMedicament(), offer.getCustomer(), product.getCount(), product.getDelay());
                //unityOfWork.getScoreRepository().save( score);
                scores.add(score);
                offer.getCustomer().getScores().add(score);
                count -= product.getCount();
                productRepository.delete(product);
            }
        }
        return scores;
    }

    private Score calculateScore(@NonNull Medicament medicament, @NonNull Customer customer, @NonNull Integer count, @NonNull Integer delay)
    {
        Score score = new Score( 0d, 10, medicament, count);/////customer
        Double price = count * medicament.getPrice();
        score.setCost( score.getCost() + (delay < 30 ? price/ 2 : price));
        return score;
    }



    public void revision()
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

    public void spendPurchaseToCustomer(Customer customer)
    {
        List<Purchase> purchases = customer.getPurchases();
        for(Purchase purchase: purchases)
        {
            purchase.setDelay(purchase.getDelay() - 1);
            if(purchase.getDelay() <= 0) {
                Offer offer = new Offer(customer, null, purchase.getCount(), purchase.getMedicament());
                System.out.println(offer);
                //customer.getOffers().add(offer);
                List<Score> scores = buyProductByOffer(offer);
                for(Score score : scores) {
                    scoreRepository.save(score);
                    customer.getScores().add(score);
                }
                System.out.println(customer);
                purchase.setDelay(purchase.getTimeDelay());
            }
           purchaseRepository.update(purchase);
        }
    }

    public void periodic()
    {
        for(Customer customer : customerRepository.getAll())
            spendPurchaseToCustomer(customer);
    }

}
