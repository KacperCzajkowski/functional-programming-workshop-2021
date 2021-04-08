package pl.allegrotech.functionalprogramming.exercises.exercise4;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise4 {

    static class Driver {

        private final Car car;

        Driver(Car car) {
            this.car = car;
        }

        Car getCar() {
            return car;
        }
    }

    static class Car {

        private final String name;

        Car(String name) {
            this.name = name;
        }

        Optional<String> getName() {
            return Optional.ofNullable(name);
        }
    }

    @Test
    public void shouldTestAudiDriver() {
        // given
        Driver audiDriver = new Driver(new Car("Audi"));
        Driver bmwDriver = new Driver(new Car("BMV"));
        Driver unknownDriver = new Driver(new Car(null));
        Driver test = new Driver(null);

        // when / then
        assertTrue(isAudiDriver(audiDriver));
        assertFalse(isAudiDriver(bmwDriver));
        assertFalse(isAudiDriver(unknownDriver));
        assertFalse(isAudiDriver(test));
        assertFalse(isAudiDriver(null));
    }

    private boolean isAudiDriver(Driver driver) {
//        return Optional.ofNullable(driver).map(Driver::getCar).flatMap(Car::getName).isPresent();
        Optional<Driver> op = Optional.ofNullable(driver);
        if (op.isPresent()) {
            Car car = op.get().getCar();
            if (car != null) {
                Optional<String> name = car.getName();
                if (name.isPresent())
                    return name.get().equals("Audi");
            }
        }
        return false;
//        Optional.ofNullable(driver).map(Driver::getCar).flatMap(Car::getName).if
    }

}
