package lightfeather.io.kanban.database.kanban.JPA;

import lightfeather.io.kanban.ticket.models.KanbanTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanbanTicketJPADatabase extends JpaRepository<KanbanTicket, Long> {
}
