import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertThrows;

class HorseTest {

    @DisplayName("firstConstructorParameterCantBeNull")
    @Test
    void fcp1() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Horse horse = new Horse(null, 2.1, 2);
        });

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @DisplayName("firstConstructorParameterThrowMessageCannotBeNull")
    @Test
    void fcp2() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Horse horse = new Horse(null, 2.1, 2);
        });

        Assertions.assertEquals("Name cannot be null.", exception.getMessage());
    }

    @DisplayName("firstConstructorParameterEmptyStringOrSimbolShouldThrowIllegalArgumentException")
    @ParameterizedTest
    @CsvSource({"'', 2.1, 2", "',,2", " , 2.1, 2"})
    @Test
    void fcp3 (String name, double height, int age) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(name, height, age));
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