package lightfeather.io.kanban.ticket.models;

import lightfeather.io.kanban.ticket.metas.TicketStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class KanbanTicket {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String user;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @CreationTimestamp
    private LocalDate creationDate;

    public KanbanTicket() {
    }

    public KanbanTicket(KanbanTicketProcessObject kanbanTicketProcessObject) throws Exception {
        id = kanbanTicketProcessObject.getId();
        name = kanbanTicketProcessObject.getName();
        description = kanbanTicketProcessObject.getDescription();
        user = kanbanTicketProcessObject.getUser();
        status = TicketStatus.fromStringForm(kanbanTicketProcessObject.getStatus());
    }

    public KanbanTicket(String name, String description, TicketStatus status, String user) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public String getCreationDateString() {
        return creationDate.getMonth().getValue() + "/" + creationDate.getDayOfMonth() + "/" + creationDate.getYear();
    }

    public void updateFromProcessObject(KanbanTicketProcessObject kanbanTicketProcessObject) throws Exception {
        setName(kanbanTicketProcessObject.getName());
        setDescription(kanbanTicketProcessObject.getDescription());
        setUser(kanbanTicketProcessObject.getUser());
        TicketStatus status = TicketStatus.fromStringForm(kanbanTicketProcessObject.getStatus());
        setStatus(status);
    }
}
