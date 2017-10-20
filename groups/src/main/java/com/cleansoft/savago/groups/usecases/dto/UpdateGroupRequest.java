package com.cleansoft.savago.groups.usecases.dto;

public class UpdateGroupRequest implements Datastructure {

    public final String groupId;
    public String groupName;

    public UpdateGroupRequest(String groupId, String groupName) {

        this.groupId = groupId;
        this.groupName = groupName;
    }
}
