import app.domain.dto.CustomerDto;
import app.domain.dto.MedicamentDto;
import app.domain.dto.OfferDto;
import app.domain.dto.ScoreDto;
import app.repository.implemantationH.CustomerRepositoryHibernate;
import app.service.AppendService;
import app.service.CustomerService;
import app.service.WarehouseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

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
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        Random rnd = new Random(100);
        for(int i = 0; i < 100; i++)
        {
            warehouseService.update();
            if(rnd.nextInt() % 83 == 0)
                appendService.generateProduction();
        }
        List<CustomerDto> customers = customerService.getAllCustomers();
        List<MedicamentDto> medicaments = customerService.getAllMedicament();
        OfferDto offerDto = new OfferDto(customers.get(0), null, 40, medicaments.get(2));
        List<ScoreDto> scoreDtos = warehouseService.buy(offerDto);
        for(ScoreDto scoreDto : scoreDtos)
            System.out.println(scoreDto);

    }

}
