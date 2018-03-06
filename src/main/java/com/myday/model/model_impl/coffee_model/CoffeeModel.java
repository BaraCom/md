package com.myday.model.model_impl.coffee_model;

import com.myday.model.model_inter.ObjectModel;
import com.myday.service.dao.dao_inter.ObjectDao;
import com.myday.service.entities.impl_entities.coffee_impl_entity.CoffeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CoffeeModel implements ObjectModel {

    @Autowired
    private ObjectDao coffeeDao;

    public CoffeeModel() {
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<CoffeeEntity> getPropositionList() {
        return (List<CoffeeEntity>) coffeeDao.getAll();
    }
}
