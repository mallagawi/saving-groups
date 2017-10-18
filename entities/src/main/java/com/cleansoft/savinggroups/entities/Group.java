package com.cleansoft.savinggroups.entities;

import org.apache.commons.lang3.StringUtils;

import static java.util.Objects.isNull;

public class Group<T> extends BusinessEntity<GroupEntityView> {


    private String groupName;
    private String groupDescription;
    private int shares;
    private String groupId;

    public Group(String groupId, String groupName, String groupDescription, int shares) {
        if (isNull(groupId)) {
            throw new InvalidGroupIdException();
        }
        if (shares <= 0 | shares > 24) {
            throw new InvalidGroupSharesException();
        }
        if (StringUtils.isBlank(groupName)) {
            throw new BlankGroupNameException();
        }

        if (isNull(groupDescription)) {
            throw new NullGroupDescriptionException();
        }


        this.groupId = groupId;
        this.shares = shares;
        this.groupDescription = groupDescription;
        this.groupName = groupName;
    }


    @Override
    public GroupEntityView view() {
        return new GroupEntityView(this.groupId, this.groupName, this.groupDescription, this.shares);
    }

    public Group updateGroupName(String groupName) {
        if (!StringUtils.isBlank(groupName)) {
            this.groupName = groupName;
        }
        return this;
    }

    public static class BlankGroupNameException extends RuntimeException {
    }

    public static class NullGroupDescriptionException extends RuntimeException {
    }

    public static class InvalidGroupSharesException extends RuntimeException {
    }

    public static class InvalidGroupIdException extends RuntimeException {
    }
}
