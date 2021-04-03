import App.Interface.UnityOfWork;
import App.Models.*;
import App.Repository.CustomerRepositoryDAO;
import App.Repository.MedicamentRepositoryDAO;
import App.Repository.UnityOfWorkImpl;
import App.Services.AppendService;
import App.Services.Warehouse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan(basePackageClasses = {CustomerRepositoryDAO.class, AppendService.class})
public class ConsoleApplication
{
    public static void main(String[] a)
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConsoleApplication.class);
        AppendService appendService = applicationContext.getBean(AppendService.class);
        appendService.testData();
        Warehouse warehouse = applicationContext.getBean(Warehouse.class);

        for(int i = 0; i < 100; i++)
        {
            warehouse.periodic();
            warehouse.revision();
        }

    }


}
