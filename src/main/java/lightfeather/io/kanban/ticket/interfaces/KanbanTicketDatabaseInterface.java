package lightfeather.io.kanban.ticket.interfaces;

import lightfeather.io.kanban.ticket.models.KanbanTicket;

import java.util.List;
import java.util.Optional;

public interface KanbanTicketDatabaseInterface {

    public KanbanTicket save(KanbanTicket kanbanTicket);
    public List<KanbanTicket> getAll();
    public Optional<KanbanTicket> getById(Long id);
}
