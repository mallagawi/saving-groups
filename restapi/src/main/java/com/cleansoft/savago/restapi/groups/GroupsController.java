package com.cleansoft.savago.restapi.groups;


import com.cleansoft.savago.entities.GroupEntityView;
import com.cleansoft.savago.groups.usecases.AddGroupUseCase;
import com.cleansoft.savago.groups.usecases.dto.AddGroupRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupsController {

    @RequestMapping(value = "/addNewGroup/{id}/{name}/{shares}", method = RequestMethod.GET, headers = "Accept=application/xml")
    public String addNewGroup(@PathVariable("id") String id, @PathVariable("name") String name, @PathVariable("shares") int shares) {
        FileGateway gateway = new FileGateway();
        GroupEntityView view;
        try {
            new AddGroupUseCase(gateway).execute(new AddGroupRequest(id, name, name, shares));
            view = (GroupEntityView) gateway.findById(id).view();
        } catch (Exception e) {
            return "<?xml version=\"1.0\"?><error>" + e + "</error>";
        }
        return "<?xml version=\"1.0\"?><result>"+ view.toString() +"</result>";

    }
}
