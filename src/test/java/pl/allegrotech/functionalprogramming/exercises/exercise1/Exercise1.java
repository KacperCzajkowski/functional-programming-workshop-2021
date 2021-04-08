package pl.allegrotech.functionalprogramming.exercises.exercise1;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise1 {

    @Test
    public void shouldTestMeasuringExecutionTime() {
        // given / when
        String result = measured(this::executeBusinessLogic);
        /*long execTime = */voidMeasured(this::executeBusinessLogicFromTheVoid);
        assertEquals(result, "DONE");
    }

    private String executeBusinessLogic() {
        System.out.println("Doing important thing...");
        return "DONE";
    }

    private void executeBusinessLogicFromTheVoid() {
        System.out.println("Counting stars or sth...");
//        return new Void();
    }

    private String measured(Supplier<String> function) {
        long start = System.currentTimeMillis();
        String result = function.get();
        System.out.println(System.currentTimeMillis() - start);
        return result;
    }

    private void voidMeasured(Runnable function) {
        long start = System.currentTimeMillis();
        function.run();
//        return System.currentTimeMillis() - start;
    }
}

@FunctionalInterface
interface VoidSupplier {
    void get();
}
