package com.cleansoft.savinggroups.entities;

import com.cleansoft.savinggroups.entities.Group.InvalidGroupSharesException;
import com.cleansoft.savinggroups.entities.Group.NullGroupDescriptionException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GroupTest {


    private final int VALID_SHARES = 10;

    @Test(expected = Group.InvalidGroupIdException.class)
    public void givenNullGroupId_whenCreate_thenShouldThrowException() {
        new Group(null,"groupName", "", VALID_SHARES);

    }

    @Test(expected = Group.BlankGroupNameException.class)
    public void givenEmptyGroupName_whenCreate_thenShouldThrowException() {
        new Group("1", "", null, VALID_SHARES);
    }

    @Test(expected = Group.BlankGroupNameException.class)
    public void givenNullGroupName_whenCreate_thenShouldThrowException() {
        new Group("1", null, null, VALID_SHARES);
    }

    @Test(expected = NullGroupDescriptionException.class)
    public void givenGroupDescriptionNull_whenCreate_thenShouldThrowException() {
        new Group("1", "groupName", null, VALID_SHARES);
    }

    @Test(expected = InvalidGroupSharesException.class)
    public void givenGroupSharesWithValueOfLessOrEqualToZero_whenCreate_ThenShouldThrowException() {
        new Group("1", "groupName", "description", 0);
    }

    @Test(expected = InvalidGroupSharesException.class)
    public void givenGroupSharesGreaterThan24_whenCreate_thenShouldThrowException() {
        new Group("1", "groupName", "description", 25);
    }

    @Test
    public void givenGroup_whenView_thenShouldReturnGroupEntityViewOfSameGroupFields() {
        Group group = new Group("1", "groupName", "description", VALID_SHARES);
        GroupEntityView view = group.view();

        assertEquals("1",view.groupId);
        assertEquals("groupName",view.groupName);
        assertEquals("description",view.groupDescription);
        assertEquals(VALID_SHARES,view.groupShares);

    }
}
