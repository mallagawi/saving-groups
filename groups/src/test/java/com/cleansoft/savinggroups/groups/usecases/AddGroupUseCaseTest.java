package com.cleansoft.savinggroups.groups.usecases;

import com.cleansoft.savinggroups.groups.usecases.AddGroupUseCase.InvalidRequestException;
import com.cleansoft.savinggroups.groups.usecases.AddGroupUseCase.NullGatewayException;
import com.cleansoft.savinggroups.groups.usecases.dto.AddGroupRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AddGroupUseCaseTest {

    private InMemoryGroupsGateway gateway;

    @Before
    public void setUp() throws Exception {
        gateway = new InMemoryGroupsGateway();
    }

    @Test
    public void canCreateAddGroupUseCase() {
        new AddGroupUseCase(gateway);
    }

    @Test(expected = InvalidRequestException.class)
    public void givenNullRequest_whenExecute_thenShouldThrowException() {
        new AddGroupUseCase(gateway).execute(null);
    }

    @Test(expected = InvalidRequestException.class)
    public void givenRequestWithBlankGroupName_whenExecute_thenShouldThrowException() {
        new AddGroupUseCase(gateway).execute(new AddGroupRequest("1", null, "desc",1));
    }

    @Test(expected = InvalidRequestException.class)
    public void givenRequestWithNullGroupDescription_whenExecute_thenShouldThrowException() {
        AddGroupRequest request = new AddGroupRequest("1", "groupName", null,1);
        new AddGroupUseCase(gateway).execute(request);
    }

    @Test(expected = NullGatewayException.class)
    public void givenNullGateway_whenCreateUseCase_thenShouldThrowException() {
        new AddGroupUseCase(null);
    }


    @Test
    public void givenGatewayAndRequest_whenExecute_thenShouldCreateNewGroup() {
        String actualGroupName = "myGroup";
        String actualDescription = "description";
        int actualShares = 10;
        new AddGroupUseCase(gateway).execute(new AddGroupRequest("1",actualGroupName, actualDescription, actualShares));

        assertNotEquals("",gateway.store.get("1").view().groupId);
        assertEquals("myGroup", gateway.store.get("1").view().groupName);
        assertEquals(actualDescription, gateway.store.get("1").view().groupDescription);
        assertEquals(actualShares, gateway.store.get("1").view().groupShares);
    }

}
