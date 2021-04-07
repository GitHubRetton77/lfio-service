package lightfeather.io.kanban.database.kanban;

import lightfeather.io.kanban.database.kanban.JPA.KanbanTicketJPADatabase;
import lightfeather.io.kanban.ticket.interfaces.KanbanTicketDatabaseInterface;
import lightfeather.io.kanban.ticket.models.KanbanTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KanbanTicketDatabaseService implements KanbanTicketDatabaseInterface {

    @Autowired
    private KanbanTicketJPADatabase kanbanTicketJPADatabase;

    @Override
    public KanbanTicket save(KanbanTicket kanbanTicket) {
        return kanbanTicketJPADatabase.save(kanbanTicket);
    }

    @Override
    public List<KanbanTicket> getAll() {
        return kanbanTicketJPADatabase.findAll();
    }

    @Override
    public Optional<KanbanTicket> getById(Long id) {
        return kanbanTicketJPADatabase.findById(id);
    }
}
