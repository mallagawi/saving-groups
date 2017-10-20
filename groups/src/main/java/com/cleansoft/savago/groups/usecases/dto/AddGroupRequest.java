package com.cleansoft.savago.groups.usecases.dto;

public class AddGroupRequest implements Datastructure {
    public String groupName;
    public String groupDescription;
    public int groupShares;
    public String groupId;

    public AddGroupRequest(String groupId, String groupName, String groupDescription, int groupShares) {

        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupShares = groupShares;
    }
}
