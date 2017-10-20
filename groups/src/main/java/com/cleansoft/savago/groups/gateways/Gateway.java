package com.cleansoft.savago.groups.gateways;


import com.cleansoft.savago.entities.BusinessEntity;

public interface Gateway<E extends BusinessEntity> {
    void save(BusinessEntity entity);

    E findById(String groupId);

    E update(BusinessEntity entity);
}
