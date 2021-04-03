package App.Repository;

import App.Interface.Dao;
import App.Models.Purchase;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PurchaseRepositoryDAO implements Dao<Purchase>
{
    private List<Purchase> purchases = new ArrayList<>();
    @Override
    public Purchase get(long id)
    {
        for(Purchase purchase : purchases)
            if(purchase.getId() == id)
                return purchase;
        return null;
    }

    @Override
    public List<Purchase> getAll()
    {
        return purchases;
    }

    @Override
    public void save(Purchase purchase)
    {
        purchases.add(purchase);
    }

    @Override
    public void update(Purchase purchase)
    {
        Purchase purchase1 = get(purchase.getId());
        if(purchase1 == null)
            return;
        purchase1.setCount(purchase.getCount());
        purchase1.setDelay(purchase.getDelay());
        purchase1.setMedicament(purchase.getMedicament());
    }

    @Override
    public void delete(Purchase purchase)
    {
        purchases.remove(purchase);
    }

}
