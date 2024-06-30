import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(contactService.addContact(contact));
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertFalse(contactService.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("1"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        assertFalse(contactService.deleteContact("2"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertTrue(contactService.updateContact("1", "Jane", "Smith", "0987654321", "456 Elm St"));
        Contact updatedContact = contactService.getContact("1");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        assertFalse(contactService.updateContact("2", "Jane", "Smith", "0987654321", "456 Elm St"));
    }
}