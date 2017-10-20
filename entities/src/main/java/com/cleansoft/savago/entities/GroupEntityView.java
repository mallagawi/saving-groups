package com.cleansoft.savago.entities;

public class GroupEntityView implements EntityView {
    public String groupId;
    public String groupName;
    public String groupDescription;
    public int groupShares;

    public GroupEntityView(String groupId, String groupName, String groupDescription, int shares) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupShares = shares;
    }
}
