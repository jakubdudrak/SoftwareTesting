import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
    Driver john = new Driver("John", 00123);

    @Test
    public void getDriverName(){
        assertEquals("John", john.getDriverName());
    }

}