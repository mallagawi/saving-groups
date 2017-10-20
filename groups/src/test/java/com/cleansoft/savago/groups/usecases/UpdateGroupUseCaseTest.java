package com.cleansoft.savago.groups.usecases;

import com.cleansoft.savago.groups.usecases.dto.UpdateGroupRequest;
import com.cleansoft.savago.groups.usecases.dto.AddGroupRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UpdateGroupUseCaseTest {

    private InMemoryGroupsGateway gateway;

    @Before
    public void setUp() throws Exception {
        gateway = new InMemoryGroupsGateway();
    }

    @Test
    public void canCreateUpdateGroupUseCase() {
        new UpdateGroupUseCase(gateway);
    }

    @Test(expected = UpdateGroupUseCase.NullGatewayException.class)
    public void givenNullGateway_whenCreate_thenShouldThrowException() {
        new UpdateGroupUseCase(null);
    }

    @Test(expected = UpdateGroupUseCase.InvalidRequestException.class)
    public void givenNullRequest_whenExecute_thenShouldThrowException() {

        new UpdateGroupUseCase(gateway).execute(null);

    }

    @Test
    public void givenRequestWithCertainGroupUpdates_whenExecute_thenTheGroupShouldBeUpdated() {
        new AddGroupUseCase(gateway).execute(new AddGroupRequest("1", "group","d",1));
        new UpdateGroupUseCase(gateway).execute(new UpdateGroupRequest("1","test"));
        Assert.assertEquals("test",gateway.store.get("1").view().groupName);
    }
}
