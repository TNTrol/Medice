package App.Repository;

import App.Interface.DaoKeyObject;
import App.Models.Medicament;
import App.Models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryDAO implements DaoKeyObject<Product, Medicament>
{
    private List<Product> products = new ArrayList<>();
    @Override
    public Product get(long id)
    {
        for(Product product : products)
            if(product.getId() == id)
                return product;
        return null;
    }

    @Override
    public List<Product> getAll()
    {
        return products;
    }

    @Override
    public void save(Product product)
    {
        products.add(product);
    }

    @Override
    public void update(Product product)
    {
        Product product1 = get(product.getId());
        if(product1 == null)
            return;
        product1.setMedicament(product.getMedicament());
        product1.setDelay(product.getDelay());
        product1.setCount(product.getCount());
    }

    @Override
    public void delete(Product product)
    {
        products.remove(product);
    }

    @Override
    public List<Product> getAllBy(Medicament medicament)
    {
        List<Product> list = new ArrayList<>();
        for(Product product : products)
            if(product.getMedicament().getId().equals(medicament.getId()))
                list.add(product);
        return list;
    }
}
