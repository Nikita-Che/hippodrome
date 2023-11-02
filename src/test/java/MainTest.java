import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Disabled
    @Test
    public void whenAssertingTimeout() {
        assertTimeout(java.time.Duration.ofSeconds(20), () -> {
            Main.main(new String[]{});
        });
    }

    @Disabled
    @Test
    @Timeout(value = 20)
    public void timeOut () throws Exception {
        Main.main(null);
    }
}
