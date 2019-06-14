package chris;

import java.time.Duration;
import java.time.Instant;

public class ExceptionPerformanceTest {

    public void Test() {
        Instant start = Instant.now();
        ExceptionTest(100_000);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());

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
}
