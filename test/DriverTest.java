import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
    Driver john = new Driver("John", 00123);

    @Test
    public void getDriverName(){
        assertEquals("John", john.getDriverName());
    }
    @Test
    public void check_status(){
        assertEquals(false, john.check_status());
    }

    @Test
    public void check_status_fail(){
        assertEquals(true,john.check_status());
    }

    @Test
    public void timeoutExceeded(){
        assertTimeout(Duration.ofMillis(100), () -> {
            john.waitTillbanned();
        });
    }
}