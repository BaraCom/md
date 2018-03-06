package com.myday;

import com.myday.service.dao.dao_impl.coffee_dao_impl.CoffeeDaoImpl;
import com.myday.service.entities.impl_entities.coffee_impl_entity.CoffeeEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
        CoffeeDaoImpl coffeeDaoImpl= (CoffeeDaoImpl) applicationContext.getBean("coffeeDaoImpl");

        List<CoffeeEntity> all = coffeeDaoImpl.getAll();

        for (CoffeeEntity coffeeEntity : all) {
            System.out.println(coffeeEntity.toString());
        }
    }
}
