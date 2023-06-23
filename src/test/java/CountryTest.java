import com.example.api.data.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CountryTest {

    @Test
    public void testCustomer(){
        Country c = new Country();

        assertNotNull(c);

        c.setId(1L);
        assertNotNull(c.getId());
        assertEquals(1L, c.getId());

        c.setName("Brasil");
        assertNotNull(c.getName());
        assertEquals("Brasil", c.getName());

    }

    @Test
    public void testCustomerAllArgsConstructor(){
        Country c = new Country(1L, "Brasil");

        assertNotNull(c);

        assertNotNull(c.getId());
        assertEquals(1L, c.getId());

        assertNotNull(c.getName());
        assertEquals("Brasil", c.getName());

    }

}
