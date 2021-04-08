package lightfeather.io.kanban.ticket.models;

public class KanbanTicketProcessObject {

    private Long id;

    private String description;

    private String user;

    private String status;

    private String creationDate;

    public KanbanTicketProcessObject(){
    }

    public KanbanTicketProcessObject(KanbanTicket kanbanTicket){
        id = kanbanTicket.getId();
        description = kanbanTicket.getDescription();
        user = kanbanTicket.getUser();
        creationDate = kanbanTicket.getCreationDateString();
        status = kanbanTicket.getStatus().getStringForm();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }

    public String getStatus() {
        return status;
    }

    public String getCreationDate() {
        return creationDate;
    }

}
