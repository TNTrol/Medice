package app.service;

import app.domain.dto.CustomerDto;
import app.domain.dto.MedicamentDto;
import app.domain.dto.ScoreDto;
import app.domain.entity.Customer;
import app.domain.entity.Medicament;
import app.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomerService
{
    private final IRepository<Customer> _customerRepository;
    private final IRepository<Medicament> _medicamentRepository;

    @Autowired
    public CustomerService(IRepository<Customer> customerRepository, IRepository<Medicament> medicamentRepository)
    {
        this._customerRepository = customerRepository;
        this._medicamentRepository = medicamentRepository;
    }

    public List<CustomerDto> getAllCustomers()
    {
        List<Customer> customers = _customerRepository.getAll();
        List<CustomerDto> res = new LinkedList<>();
        for(Customer customer : customers)
        {
            CustomerDto customerDto = new CustomerDto(customer.getName(), customer.getNumberPhone(), customer.getAddress());
            customerDto.setId(customer.getId());
            res.add(customerDto);
        }
        return res;
    }

    public List<MedicamentDto> getAllMedicament()
    {
        List<MedicamentDto> medicamentDtos = new LinkedList<>();
        for(Medicament medicament : _medicamentRepository.getAll()){
            MedicamentDto  medicamentDto= new MedicamentDto(medicament.getName(), medicament.getType(), medicament.getPrice());
            medicamentDto.setId(medicament.getId());
            medicamentDtos.add(medicamentDto);
        }

        return medicamentDtos;
    }
}
