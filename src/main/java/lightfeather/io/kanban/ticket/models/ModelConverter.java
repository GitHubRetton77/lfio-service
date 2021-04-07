package lightfeather.io.kanban.ticket.models;

import java.util.List;
import java.util.stream.Collectors;

public class ModelConverter {

    public static List<KanbanTicketProcessObject> getProcesstObjectsFromStoreObjects(List<KanbanTicket> listOfProcessObjects){
        return listOfProcessObjects.stream().map(kanbanTicket -> new KanbanTicketProcessObject(kanbanTicket)).collect(Collectors.toList());
    }
}
