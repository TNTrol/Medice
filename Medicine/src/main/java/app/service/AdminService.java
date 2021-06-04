package app.service;

import app.domain.entity.Customer;
import app.domain.entity.Medicament;
import app.repository.IRepository;
import app.domain.dto.CustomerDto;
import app.domain.dto.MedicamentDto;
import app.domain.dto.TypeMedicament;

import java.util.List;

public class AdminService
{

    private IRepository<Medicament> medicamentRepository;
    public IRepository<Customer> customerRepository;

    public void addNewMedicament(String name, TypeMedicament type, Double price)
    {
        Medicament medicament = new Medicament();
        medicament.setPrice(price);
        medicament.setName(name);
        medicament.setType(type.toString());
        medicamentRepository.save(medicament);
    }

    public List<Medicament> showAllMedicament()
    {
        return medicamentRepository.getAll();
    }

    public List<Customer> showAllCustomers()
    {
        return customerRepository.getAll();
    }


}
