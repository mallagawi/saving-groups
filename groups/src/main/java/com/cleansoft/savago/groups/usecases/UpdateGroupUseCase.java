package com.cleansoft.savago.groups.usecases;

import com.cleansoft.savago.entities.Group;
import com.cleansoft.savago.groups.gateways.Gateway;
import com.cleansoft.savago.groups.usecases.dto.UpdateGroupRequest;

import static java.util.Objects.isNull;

public class UpdateGroupUseCase implements CommandUseCase<UpdateGroupRequest> {
    private final Gateway gateway;

    public UpdateGroupUseCase(Gateway gateway) {
        if (isNull(gateway))
            throw new NullGatewayException();
        this.gateway = gateway;
    }



    @Override
    public void execute(UpdateGroupRequest request) {

        if(isNull(request))
            throw new InvalidRequestException();
        Group currentGroup = (Group) gateway.findById(request.groupId);
        gateway.update(currentGroup.updateGroupName(request.groupName));
    }

    public static class NullGatewayException extends RuntimeException {
    }

    public static class InvalidRequestException extends RuntimeException{
    }
}
