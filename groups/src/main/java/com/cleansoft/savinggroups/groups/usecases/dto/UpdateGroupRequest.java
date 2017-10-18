package com.cleansoft.savinggroups.groups.usecases.dto;

public class UpdateGroupRequest {

    public final String groupId;
    public String groupName;

    public UpdateGroupRequest(String groupId, String groupName) {

        this.groupId = groupId;
        this.groupName = groupName;
    }
}
