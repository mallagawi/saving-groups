package com.cleansoft.savinggroups.groups.usecases;

import com.cleansoft.savinggroups.entities.BusinessEntity;
import com.cleansoft.savinggroups.entities.Group;
import com.cleansoft.savinggroups.groups.usecases.dto.UpdateGroupRequest;
import com.cleansoft.savinggroups.groups.gateways.Gateway;

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
