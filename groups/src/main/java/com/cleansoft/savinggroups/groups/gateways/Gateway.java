package com.cleansoft.savinggroups.groups.gateways;


import com.cleansoft.savinggroups.entities.BusinessEntity;

public interface Gateway<E extends BusinessEntity> {
    void save(BusinessEntity entity);

    E findById(String groupId);

    E update(BusinessEntity entity);
}
