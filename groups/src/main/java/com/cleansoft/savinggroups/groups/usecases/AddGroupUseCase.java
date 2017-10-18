package com.cleansoft.savinggroups.groups.usecases;

import com.cleansoft.savinggroups.entities.Group;
import com.cleansoft.savinggroups.groups.gateways.Gateway;
import com.cleansoft.savinggroups.groups.usecases.dto.AddGroupRequest;
import org.apache.commons.lang3.StringUtils;

import static java.util.Objects.isNull;

public class AddGroupUseCase implements CommandUseCase<AddGroupRequest> {

    private final Gateway gateway;

    public AddGroupUseCase(Gateway gateway) {

        if (isNull(gateway))
            throw new NullGatewayException();
        this.gateway = gateway;
    }

    public void execute(AddGroupRequest request) {
        validateRequest(request);
        Group group = new Group(request.groupId, request.groupName, request.groupDescription, request.groupShares);
        gateway.save(group);
    }

    private void validateRequest(AddGroupRequest request) {
        if (isNull(request) || isNull(request.groupDescription)) {
            throw new InvalidRequestException();
        }

        if (StringUtils.isBlank(request.groupName)) {
            throw new InvalidRequestException();
        }
    }

    public static class InvalidRequestException extends RuntimeException {
    }

    public static class NullGatewayException extends RuntimeException {
    }
}
