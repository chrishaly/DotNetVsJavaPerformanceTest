package chris;

import java.time.Duration;
import java.time.Instant;

public class ExceptionPerformanceTest {

    public void Test() {
        Instant start = Instant.now();
        System.out.println(ExceptionTest(1000_000));
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());

    }

    private long ExceptionTest(long times) {
        long result = 0;
        for (int i = 0; i < times; i++) {
            try {
                Throw();
            } catch (Exception ex) {
                //Ignore
                result++;
            }
        }
        return result;
    }

    private void Throw() throws Exception {
        throw new Exception();
    }
}
