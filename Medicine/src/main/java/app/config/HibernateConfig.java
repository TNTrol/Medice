package app.config;

import app.domain.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConfig
{

        private static SessionFactory sessionFactory;

        public HibernateConfig() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration().configure();
                    configuration.addAnnotatedClass(Customer.class);
                    configuration.addAnnotatedClass(DiscountCard.class);
                    configuration.addAnnotatedClass(Medicament.class);
                    configuration.addAnnotatedClass(Offer.class);
                    configuration.addAnnotatedClass(Product.class);
                    configuration.addAnnotatedClass(Purchase.class);
                    configuration.addAnnotatedClass(Score.class);
                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                    sessionFactory = configuration.buildSessionFactory(builder.build());

                } catch (Exception e) {
                    System.out.println("Исключение!" + e);
                }
            }
        }

        public  SessionFactory getSessionFactory() {
            return sessionFactory;
        }

}
