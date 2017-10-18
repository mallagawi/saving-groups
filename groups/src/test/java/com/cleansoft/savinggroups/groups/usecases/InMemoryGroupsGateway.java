package com.cleansoft.savinggroups.groups.usecases;

import com.cleansoft.savinggroups.entities.BusinessEntity;
import com.cleansoft.savinggroups.entities.Group;
import com.cleansoft.savinggroups.entities.GroupEntityView;
import com.cleansoft.savinggroups.groups.gateways.Gateway;

import java.util.HashMap;
import java.util.Map;

public class InMemoryGroupsGateway implements Gateway {
    public String groupId;
    public String groupName;
    public String groupDescription;
    public int groupShares;
    public Map<String, Group> store = new HashMap<>();


    @Override
    public void save(BusinessEntity entity) {
        Group group = (Group) entity;
        GroupEntityView view = group.view();
        store.put(view.groupId,group);
    }

    @Override
    public BusinessEntity findById(String groupId) {
        return store.get(groupId);
    }

    @Override
    public BusinessEntity update(BusinessEntity entity) {
        Group group = (Group) entity;
        GroupEntityView view = group.view();
        store.put(view.groupId,group);
        return store.get(view.groupId);
    }
}
