import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HippodromeTest {
    private List<Horse> horses = new ArrayList<>();

    @DisplayName("shouldThrowExceptionAndMessage")
    @Test
    void nameException() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Hippodrome hippodrome = new Hippodrome(null);
        });
        Assertions.assertEquals(IllegalArgumentException.class, throwable.getClass());
        Assertions.assertEquals(throwable.getMessage(), "Horses cannot be null.");
    }

    @DisplayName("shouldThrowExceptionWithEmptyList")
    @Test
    void horsesEmptyListTest() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            List<Horse> horses = Collections.emptyList();
            Hippodrome hippodrome = new Hippodrome(horses);
        });
        Assertions.assertEquals(IllegalArgumentException.class, throwable.getClass());
        Assertions.assertEquals(throwable.getMessage(), "Horses cannot be empty.");
    }


    @Test
    void getHorses() {
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("Кляча", 2.0, 1));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        Assertions.assertEquals(hippodrome.getHorses(), horses);
    }

    @Test
    void move() {
        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for (Horse mockHorse : horses) {
            Mockito.verify(mockHorse).move();
        }
    }

    @Test
    void getWinner() {
        Horse horse1 = Mockito.mock(Horse.class);
        Mockito.when(horse1.getDistance()).thenReturn(10.0);

        Horse horse2 = Mockito.mock(Horse.class);
        Mockito.when (horse2.getDistance()).thenReturn(15.0);

        Horse horse3 = Mockito.mock(Horse.class);
        Mockito.when (horse3.getDistance()).thenReturn(5.0);

        List<Horse> horses = Arrays.asList(horse1, horse2, horse3);
        Hippodrome hippodrome = new Hippodrome(horses);

        Horse winner = hippodrome.getWinner();
        Assertions.assertEquals(horse2, winner);
    }
}