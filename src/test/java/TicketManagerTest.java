import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1, 2000, "LED", "GOJ", 120);
    Ticket ticket2 = new Ticket(2, 2500, "KUF", "OGZ", 180);
    Ticket ticket3 = new Ticket(3, 1800, "LED", "GOJ", 150);
    Ticket ticket4 = new Ticket(4, 2300, "GOJ", "OGZ", 170);
    Ticket ticket5 = new Ticket(5, 2100, "LED", "GOJ", 110);

    @Test
    public void shouldFindTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        manager.searchBy("KUF", "OGZ");

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.searchBy("KUF", "OGZ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        manager.searchBy("LED", "OGZ");

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("LED", "OGZ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketSort() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        manager.searchBy("LED", "GOJ");

        Ticket[] expected = {ticket3, ticket1, ticket5};
        Ticket[] actual = manager.searchBy("LED", "GOJ");

        Assertions.assertArrayEquals(expected, actual);
    }
}
