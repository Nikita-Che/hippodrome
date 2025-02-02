import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

class HorseTest {

    @DisplayName("nameCanNotBeNull")
    @Test
    void nameNull() {
//        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//            Horse horse = new Horse(null, 2.1, 2);
//        });
//
//        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());

        Assertions.assertThrows(IllegalArgumentException.class, ()->new Horse(null, 2.1, 2));
    }

    @DisplayName("nameThrowMessageCannotBeNull")
    @Test
    void nameThrowMessage() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Horse horse = new Horse(null, 2.1, 2);
        });

        Assertions.assertEquals("Name cannot be null.", exception.getMessage());
    }

    @DisplayName("nameEmptyStringOrSimbolShouldThrowIllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "  ", "\n", " \t \n "})
    void nameEmptyString(String blankName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(blankName, 2.1, 1));
    }

    @DisplayName("nameThrowMessageCannotBeBlanc")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "  ", "\n", " \t \n "})
    void nameThrowMessageBlanc(String name) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(name, 2.1, 1));
        Assertions.assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @DisplayName("speedThrowIllegalArgumentException")
    @Test
    void speedThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Кляча", -1, 1));
    }

    @DisplayName("speedShowMsgSpeedCannotBeNegative")
    @Test
    void speedShowMessage() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Horse horse = new Horse("Кляча", -1, 1);
        });

        Assertions.assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @DisplayName("distanceThrowIllegalArgumentException")
    @Test
    void distanceException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Кляча", 2.0, -1));
    }

    @DisplayName("distanceShowMsgDistanceCannotBeNegative")
    @Test
    void distanceMessage() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Horse horse = new Horse("Кляча", 2.0, -1);
        });

        Assertions.assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getHorseName() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse("Кляча", 0.1, 1);
        String actual = horse.getName();
        String expected = "Кляча";
        Assertions.assertEquals(expected, actual);

        //разбор предлагает рефлексию. Надо ли так делать?
        Horse h = new Horse("Кляча", 0.1, 1);
        Field name = Horse.class.getDeclaredField("name");
        name.setAccessible(true);
        String nameValue = (String) name.get(h);
        Assertions.assertEquals("Кляча", nameValue);
    }

    @Test
    void getHorseSpeed() {
        Horse horse = new Horse("Кляча", 0.1, 1);
        double actual = horse.getSpeed();
        double expected = 0.1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHorseDistance() {
        Horse horse = new Horse("Кляча", 0.1, 1);
        double actual = horse.getDistance();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHorseDistanceZeroWithNo3Parameter() {
        Horse horse = new Horse("Кляча", 0.1);
        double actual = horse.getDistance();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @ExtendWith(MockitoExtension.class)
    @Test
    void move() {
        try (MockedStatic<Horse> horseMockedStatic = Mockito.mockStatic(Horse.class)) {
            new Horse("Кляча", 1).move();
            horseMockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @Test
    void getRandomDouble() {

        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            Mockito.when(Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.5);
            Horse horse = new Horse("Кляча", 10.0, 100.0);
            horse.move();

            Assertions.assertEquals(100.0 + 10.0 * 0.5, horse.getDistance());
        }
    }
}