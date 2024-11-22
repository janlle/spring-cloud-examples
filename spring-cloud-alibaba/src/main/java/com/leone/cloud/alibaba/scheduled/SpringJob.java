package com.leone.cloud.alibaba.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SpringJob {

    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 每5分钟跑一次
     */
    @Scheduled(cron = "0 */5 * * * ?")
    @SchedulerLock(name = "SpringJob.job1", lockAtMostFor = "2m", lockAtLeastFor = "1m")
    public void job1() {
        System.out.println("time=" + LocalDateTime.now().format(df) + " do job1...");
    }

    /**
     * 每5秒跑一次
     */
    @Scheduled(fixedRate = 5000)
    @SchedulerLock(name = "SpringJob.job2", lockAtMostFor = "4s", lockAtLeastFor = "4s")
    public void job2() {
        System.out.println("time=" + LocalDateTime.now().format(df) + " do job2...");
    }

    /**
     * 上次跑完之后隔5秒再跑
     */
    @Scheduled(fixedDelay = 5000)
    @SchedulerLock(name = "SpringJob.job3", lockAtMostFor = "4s", lockAtLeastFor = "4s")
    public void job3() throws InterruptedException {
        System.out.println("time=" + LocalDateTime.now().format(df) + " do job3...");
        Thread.sleep(10000);
    }

}