package lightfeather.io.kanban.ticket;

import lightfeather.io.kanban.database.kanban.KanbanTicketDatabaseService;
import lightfeather.io.kanban.ticket.interfaces.KanbanTicketServiceInterface;
import lightfeather.io.kanban.ticket.models.KanbanTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KanbanTicketService implements KanbanTicketServiceInterface {

    @Autowired
    private KanbanTicketDatabaseService kanbanTicketDatabaseService;

    @Override
    public KanbanTicket save(KanbanTicket kanbanTicket) {
        return kanbanTicketDatabaseService.save(kanbanTicket);
    }

    @Override
    public List<KanbanTicket> getAll() {
        return kanbanTicketDatabaseService.getAll();
    }

    @Override
    public Optional<KanbanTicket> getById(Long id) {
        return kanbanTicketDatabaseService.getById(id);
    }
}
