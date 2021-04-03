package App.Repository;

import App.Interface.Dao;
import App.Models.Customer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepositoryDAO implements Dao<Customer>
{

    private List<Customer> customers = Arrays.asList(new Customer[]{new Customer("name_1", "787667", "street"), new Customer("name_2", "57859", "street2")});
    @Override
    public Customer get(long id)
    {
        for(Customer customer : customers)
            if(customer.getId() == id)
                return  customer;
        return null;
    }

    @Override
    public List<Customer> getAll()
    {
        return customers;
    }

    @Override
    public void save(Customer customer)
    {
        customers.add(customer);
    }

    @Override
    public void update(Customer customer)
    {
        Customer customer1 = get(customer.getId());
        if(customer1 == null)
            return;
        customer1.setAddress(customer.getAddress());
        customer1.setName(customer.getName());
        customer1.setNumberPhone(customer.getNumberPhone());
    }

    @Override
    public void delete(Customer customer)
    {
        customers.remove(customer);
    }
}
