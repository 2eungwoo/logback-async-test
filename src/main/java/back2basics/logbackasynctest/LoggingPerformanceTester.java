package back2basics.logbackasynctest;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingPerformanceTester {

    @PostConstruct
    public void runLoggingTest() {
        final int COUNT = 1_000_000;

        // ✅ [3] Logger 이름을 클래스명으로 지정 (MDC 설정 → SiftingAppender 용)
        MDC.put("loggerClass", this.getClass().getSimpleName());

        log.info("===== Logging performance test started: {} messages =====", COUNT);
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            log.info("Log entry number {}", i);
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        log.info("===== Logging finished in {} ms =====", duration);
        log.info("===== Throughput: {} logs/sec =====", COUNT * 1000L / duration);

        MDC.clear(); // ✅ MDC 클리어
    }
}