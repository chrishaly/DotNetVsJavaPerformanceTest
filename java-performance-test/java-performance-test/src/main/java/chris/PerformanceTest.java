package chris;

import java.time.Duration;
import java.time.Instant;

public class PerformanceTest {

    public void Test() {
        Measure(() -> ExceptionTest(100_000), "ExceptionTest(100_000)");
        Measure(() -> ParseIntTest(1_000_000), "ParseIntTest(1_000_000)");
        Measure(() -> LongSumTest(100_000_000), "LongSumTest(100_000_000)");
    }

    public void Measure(Runnable action, String name) {
        Instant start = Instant.now();
        action.run();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(name + "\t" + duration.toMillis());
    }

    private void ExceptionTest(long times) {
        for (int i = 0; i < times; i++) {
            try {
                throw new Exception();
            } catch (Exception ex) {
                //Ignore
            }
        }
    }

    private void ParseIntTest(long times) {
        for (int i = 0; i < times; i++) {
            Integer.parseInt("1");
        }
    }

    private long LongSumTest(long times) {
        long result = 0;
        for (long i = 0; i < times; i++) {
            result += i;
        }
        //System.out.println(result);
        return result;
    }
}
