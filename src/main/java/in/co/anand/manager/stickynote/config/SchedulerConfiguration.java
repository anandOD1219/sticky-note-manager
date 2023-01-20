package in.co.anand.manager.stickynote.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

@Configuration
public class SchedulerConfiguration {

    @Value("${stickynote.jdbc.scheduler.poolsize}")
    private Integer connectionPoolSize;

    @Bean
    public Scheduler jdbcScheduler() {
        return Schedulers.fromExecutor(Executors.newFixedThreadPool(connectionPoolSize));
    }
}
