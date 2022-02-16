import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
    Driver john = new Driver("John", 123);

    @Test
    public void getDriverName(){
        assertEquals("John", john.getDriverName());
    }
    @Test
    public void check_status(){
        assertEquals(false, john.check_status());
    }

    @Test
    public void timeoutExceeded(){
        assertTimeout(Duration.ofMillis(150), () -> {
            john.waitTillbanned();
        });
    }

    @Test
    public void setDriverNum() throws Exception {
        Method method = Driver.class.getDeclaredMethod("setDriverNum", int.class);
        method.setAccessible(true);
        method.invoke(john,101);

        Class driver = john.getClass();
        Field age = driver.getDeclaredField("driverNum");
        age.setAccessible(true);

        int result = age.getInt(john);
        assertEquals(101, result);
    }
}