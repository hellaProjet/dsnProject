package com.advyteam.dsn;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by hboulahia on 20/10/19.
 */
public class job {

    public class BatchPersonne
    {
        public  void main (String [] args) throws Exception
        {
            System.out.println("the job start running");
            ClassPathXmlApplicationContext cpt = new ClassPathXmlApplicationContext("dsn-configuration-job.xml");
            cpt.start();
            JobLauncher jobLauncher = (JobLauncher) cpt.getBean("jobLauncher");
            Job job = (Job) cpt.getBean("importDsn");
            JobParameters parameter = new JobParametersBuilder().addDate("date", new Date()).addString("input.file", "/home/hboulahia/Téléchargements/fDSN-201909-NET-24-09-2019-15-00-22.dsn").toJobParameters();
            jobLauncher.run(job, parameter);
            System.out.println("the job end running");

        }
    }
}
