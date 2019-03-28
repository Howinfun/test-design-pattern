package com.hyf.testdesignpattern.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;

public class TestCronTrigger {
    public static void main(String[] args) throws Exception{
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail detail = newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("name","howinfun")
                .usingJobData("age",25)
                .build();

        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        cronTrigger.setName("trigger1");
        cronTrigger.setGroup("group1");
        cronTrigger.setCronExpression("0/2 * * * * ?");
        cronTrigger.setStartTime(new Date());
        cronTrigger.setEndTime(new Date(new Date().getTime()+1000*20));

        scheduler.scheduleJob(detail,cronTrigger);
        scheduler.start();
    }
}
