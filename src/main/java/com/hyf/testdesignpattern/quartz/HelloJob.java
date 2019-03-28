package com.hyf.testdesignpattern.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail detail = jobExecutionContext.getJobDetail();
        String name = detail.getJobDataMap().getString("name");
        Integer age = detail.getJobDataMap().getInt("age");
        System.out.println("my name is "+name+" and i'm "+age+" years old "+new Date());

    }
}
