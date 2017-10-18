import com.cleansoft.savinggroups.entities.BusinessEntity;
import com.cleansoft.savinggroups.entities.Group;
import com.cleansoft.savinggroups.entities.GroupEntityView;
import com.cleansoft.savinggroups.groups.gateways.Gateway;
import javafx.application.Application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGateway implements Gateway {
    File groups = new File("/home/u483/groups.txt");

    @Override
    public void save(BusinessEntity entity) {
        try(FileWriter fileWriter = new FileWriter(groups)) {
            Group group = (Group) entity;
            GroupEntityView view = group.view();
            fileWriter.write(view.groupId + "|" + view.groupName + "|" + view.groupDescription + "|" + view.groupShares + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BusinessEntity findById(String groupId) {
        return null;
    }

    @Override
    public BusinessEntity update(BusinessEntity entity) {
        return null;
    }
}
