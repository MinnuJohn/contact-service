import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactInvalidId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    public void testContactInvalidFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    public void testContactInvalidLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", null, "1234567890", "123 Main St");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    public void testContactInvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "123", "123 Main St");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void testContactInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", null);
        });
        assertEquals("Invalid address", exception.getMessage());
    }

    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetPhone() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }
}
