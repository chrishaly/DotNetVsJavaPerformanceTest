package chris;

import java.time.Duration;
import java.time.Instant;

public class ExceptionPerformanceTest {

    public void Test() throws Exception {
        Instant start = Instant.now();
        System.out.println(ExceptionTest(1000_000));
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());

    }

    private long ExceptionTest(long times) throws Exception {
        long result = 0;
        for (int i = 0; i < times; i++) {
            try {
                Throw();
            } catch (Exception ex) {
                if(!ex.getMessage().equals("message")){
                    throw new Exception("test failed");
                }
                //Ignore
                result++;
            }
        }
        return result;
    }

    private void Throw() throws Exception {
        throw new Exception("message");
    }
}
