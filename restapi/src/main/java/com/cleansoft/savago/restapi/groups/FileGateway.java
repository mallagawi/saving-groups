package com.cleansoft.savago.restapi.groups;

import com.cleansoft.savago.entities.BusinessEntity;
import com.cleansoft.savago.entities.Group;
import com.cleansoft.savago.entities.GroupEntityView;
import com.cleansoft.savago.groups.gateways.Gateway;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGateway implements Gateway {
    private File groups = new File("/home/u483/groups.txt");

    @Override
    public void save(BusinessEntity entity) {
        try (FileWriter fileWriter = new FileWriter(groups)) {
            Group group = (Group) entity;
            GroupEntityView view = group.view();
            fileWriter.write(view.groupId + "|" + view.groupName + "|" + view.groupDescription + "|" + view.groupShares + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BusinessEntity findById(String groupId) {
        throw new GroupNotFoundException();
    }

    @Override
    public BusinessEntity update(BusinessEntity entity) {
        throw new GroupNotFoundException();
    }

    private class GroupNotFoundException extends RuntimeException {
    }
}
