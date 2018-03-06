package com.myday.service.dao.dao_impl.coffee_dao_impl;

import com.myday.service.dao.dao_inter.ObjectDao;
import com.myday.service.entities.impl_entities.coffee_impl_entity.CoffeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.myday.service.utils.ConnectionFactory.*;
import static java.lang.Double.parseDouble;

@Repository
public class CoffeeDaoImpl implements ObjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<CoffeeEntity> getAll() {
        List<CoffeeEntity> list =
                sessionFactory.getCurrentSession()
                .createQuery("from CoffeeEntity").list();

        for (CoffeeEntity coffeeEntity : list) {
            System.out.println(coffeeEntity.toString());
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public double getPriceByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select price from CoffeeEntity where name in (:name)");
        query.setParameter("name", name);
        List<Double> list = query.list();

        for (Double price : list) {
            return price;
        }

        return 0;
    }
}
