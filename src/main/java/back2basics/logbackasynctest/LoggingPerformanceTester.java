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
        final int COUNT = 1000000; // 실험할 로그 수

        // 🔵 [3] 클래스명 기반 logger → SiftingAppender에서 구분
        MDC.put("loggerClass", this.getClass().getSimpleName());

        log.info("===== Logging performance test started: {} messages =====", COUNT);
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            log.info("Log entry number {}", i);
        }

        long end = System.currentTimeMillis();
        log.info("===== Logging finished in {} ms =====", (end - start));
        log.info("===== Throughput: {} logs/sec =====", COUNT * 1000L / (end - start));

        MDC.clear(); // 🔵 clear
    }
}