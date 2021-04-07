package lightfeather.io.kanban.ticket;

import lightfeather.io.kanban.ticket.interfaces.KanbanTicketServiceInterface;
import lightfeather.io.kanban.ticket.models.KanbanTicket;
import lightfeather.io.kanban.ticket.models.KanbanTicketProcessObject;
import lightfeather.io.kanban.ticket.models.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/kanban")
public class KanbanTicketController {

    @Autowired
    private KanbanTicketServiceInterface kanbanTicketService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<KanbanTicketProcessObject>> getAll() {

        List<KanbanTicket> storedKanbanTickets = kanbanTicketService.getAll();

        List<KanbanTicketProcessObject> ticketsInTransferForm = ModelConverter.getProcesstObjectsFromStoreObjects(storedKanbanTickets);

        return ResponseEntity.ok(ticketsInTransferForm);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<KanbanTicketProcessObject> create(@RequestBody KanbanTicketProcessObject kanbanTicketProcessObject) throws Exception {

        if (kanbanTicketProcessObject.getId() != null) {
            ResponseEntity.badRequest().body("New tickets should not have ids");
            throw new Exception("New tickets should not have ids");
        }

        KanbanTicket ticketStoreForm = new KanbanTicket(kanbanTicketProcessObject);

        KanbanTicket createdTicket = kanbanTicketService.save(ticketStoreForm);

        KanbanTicketProcessObject ticketInTransferForm = new KanbanTicketProcessObject(createdTicket);

        return ResponseEntity.ok(ticketInTransferForm);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<KanbanTicketProcessObject> update(@RequestBody KanbanTicketProcessObject kanbanTicketProcessObject) throws Exception {

        if (kanbanTicketProcessObject.getId() == null) {
            ResponseEntity.badRequest().body("To be updated tickets should have ids");
            throw new Exception("To be updated tickets should have ids");
        }

        Optional<KanbanTicket> ticketToBeUpdatedOptional = kanbanTicketService.getById(kanbanTicketProcessObject.getId());
        if(!ticketToBeUpdatedOptional.isPresent()){
            ResponseEntity.badRequest().body("To be updated ticket is not found");
            throw new Exception("To be updated ticket is not found");
        }

        KanbanTicket ticketStoreForm = ticketToBeUpdatedOptional.get();
        ticketStoreForm.updateFromProcessObject(kanbanTicketProcessObject);

        KanbanTicket updatedTicket = kanbanTicketService.save(ticketStoreForm);

        KanbanTicketProcessObject ticketInTransferForm = new KanbanTicketProcessObject(updatedTicket);

        return ResponseEntity.ok(ticketInTransferForm);
    }


}
