import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Disabled
    @Test
    public void whenAssertingTimeout() {
        assertTimeout(java.time.Duration.ofSeconds(20), () -> {
            Main.main(new String[]{});
        });
        //TEST
    }
}
