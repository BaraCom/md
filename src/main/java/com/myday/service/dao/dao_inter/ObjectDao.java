package com.myday.service.dao.dao_inter;

import java.util.List;

public interface ObjectDao {

    List<?> getAll();

    double getPriceByName(String name);
}
