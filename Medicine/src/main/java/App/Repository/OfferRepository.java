package App.Repository;

import App.Interface.Dao;
import App.Models.Offer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OfferRepository implements Dao<Offer>
{
    private List<Offer> offers = new ArrayList<>();
    @Override
    public Offer get(long id)
    {
        for(Offer offer : offers)
            if(offer.getId() == id)
                return offer;
        return null;
    }

    @Override
    public List<Offer> getAll()
    {
        return offers;
    }

    @Override
    public void save(Offer offer)
    {
        offers.add(offer);
    }

    @Override
    public void update(Offer offer)
    {
        Offer temp = get(offer.getId());
        if(temp == null)
            return;
        temp.setCount(offer.getCount());
        temp.setCustomer(offer.getCustomer());
        temp.setMedicament(offer.getMedicament());
        temp.setDiscountCard(offer.getDiscountCard());
    }

    @Override
    public void delete(Offer offer)
    {
        offers.remove(offer);
    }
}
