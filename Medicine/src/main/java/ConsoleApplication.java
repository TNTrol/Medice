import app.config.HibernateConfig;
import app.domain.entity.*;

import app.repository.IRepository;
import app.repository.RepositoryKeyObject;
import app.repository.implemantationH.CustomerRepositoryHibernate;
import app.repository.implemantationH.MedicamentRepositoryHibernate;
import app.repository.implemantationH.ProductRepositoryHibernate;
import app.repository.implemantationH.ScoreRepositoryHibernate;
import app.service.AppendService;
import app.service.WarehouseService;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Random;

@ComponentScan(basePackageClasses = {CustomerRepositoryHibernate.class, AppendService.class})
public class ConsoleApplication
{

    public static void main(String[] a)
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConsoleApplication.class);
        AppendService appendService = applicationContext.getBean(AppendService.class);
        WarehouseService warehouseService = applicationContext.getBean(WarehouseService.class);
        Random rnd = new Random(100);



        for(int i = 0; i < 100; i++)
        {
            warehouseService.update();
            if(rnd.nextInt() % 83 == 0)
                appendService.generateProduction();
        }




        //Hibconfig.getSessionFactory().openSession().get(Customer.class, 1);

//        HibernateConfig hibernateConfig = new HibernateConfig();
//        Session session =  hibernateConfig.getSessionFactory().openSession();
//       Transaction t = session.beginTransaction();
//        session.save(customer);

//        List<MedicamentDto> medicaments = Arrays.asList(new MedicamentDto[]{
//                new MedicamentDto("medicament1", TypeMedicament.ANTIBIOTIC, 10d),
//                new MedicamentDto("medicament2", TypeMedicament.NEUROTROPIC, 12d),
//                new MedicamentDto("medicament3", TypeMedicament.ANTIBIOTIC, 30d),
//                new MedicamentDto("medicament4", TypeMedicament.DIAGNOSTIC, 24d)});
//        for(MedicamentDto medicamentDto : medicaments){
//            Medicament medicament = new Medicament();
//            medicament.setName(medicamentDto.getName());
//            medicament.setType(medicamentDto.getType().toString());
//            medicament.setPrice(medicamentDto.getPrice());
//            session.save(medicament);
//        }
//        List<CustomerDto> customers = Arrays.asList(new CustomerDto[]{new CustomerDto("name_1", "787667", "street"), new CustomerDto("name_2", "57859", "street2")});
//        for(CustomerDto customerDto : customers)
//        {
//            Customer customer = new Customer();
//            customer.setNumberPhone(customerDto.getNumberPhone());
//            customer.setAddress(customerDto.getAddress());
//            customer.setName(customerDto.getName());
//            session.save(customer);
//        }
      //  List<Customer> customers = loadAllData(Customer.class, session);;
//        List<Medicament> medicaments = loadAllData(Medicament.class, session);
//        session.save(create(customers.get(1), medicaments.get(0), 10, 20));
//        session.save(create(customers.get(2), medicaments.get(2), 10, 10));
//        session.save(create(customers.get(0), medicaments.get(2), 7, 12));
//        session.save(create(customers.get(0), medicaments.get(3), 5, 12));
//        session.save(create(customers.get(2), medicaments.get(1), 12, 9 ));

//            t.commit();
//        Hibernate.initialize(customers.get(0).getPurchases());
//        List<Purchase> l =customers.get(0).getPurchases();
//        String hql = "from Product where medicament_id = " + medicaments.get(0).getId().toString();
//        System.out.println(hql);
//        Query query = session.createQuery(hql);
////        query.setParameter(":userName", login.getUserName());
////        query.setParameter(":password", login.getPassword());
//        List result = query.list();
//        session.close();
//
//       System.out.println();


    }

    public static Purchase create(Customer customer, Medicament medicament, Integer delay, Integer count)
    {
        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setMedicament(medicament);
        purchase.setDelay(delay);
        purchase.setTimeDelay(delay);
        purchase.setCount(count);
        return purchase;
    }


}
