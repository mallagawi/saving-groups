package com.cleansoft.savago.gateways;

import com.cleansoft.savago.groups.usecases.AddGroupUseCase;
import com.cleansoft.savago.groups.usecases.dto.AddGroupRequest;

public class TestGroups {
    public static void main(String[] args) {
        new AddGroupUseCase(new FileGateway()).execute(new AddGroupRequest("1", "Friends","desc",5));
    }
}
