import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HorseTest {

    @Test
    void firstConstructorParameterCantBeNull() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Horse horse = new Horse(null, 2.1, 2);
        });

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    void firstConstructorParameterThrowMessageCannotBeNull() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Horse horse = new Horse(null, 2.1, 2);
        });

        Assertions.assertEquals("Name cannot be null.", exception.getMessage());
    }

    @Test
    void getHorseName() {
        Horse horse = new Horse("Кляча", 0.1, 1);
        String expected = "Кляча";
        Assertions.assertEquals(expected, horse.getName());
    }

    @Test
    void getHorseSpeed() {
        Horse horse = new Horse("Кляча", 0.1, 1);
        double expected = 0.1;
        Assertions.assertEquals(expected, horse.getSpeed());
    }

    @Test
    void getHorseDistance() {
        Horse horse = new Horse("Кляча", 0.1, 1);
        int expected = 1;
        Assertions.assertEquals(expected, horse.getDistance());
    }

    @Test
    void getHorseDistanceZeroWithNo3Parameter() {
        Horse horse = new Horse("Кляча", 0.1);
        int expected = 0;
        Assertions.assertEquals(expected, horse.getDistance());
    }

    @Test
    void move() {
    }

    @Test
    void getRandomDouble() {
    }
}