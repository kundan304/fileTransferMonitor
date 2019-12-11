package com.listener;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.annotation.ManagedBean;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletContextInitializer;

import com.queueManager.Consumer;
import com.queueManager.FileMapper;
import com.queueManager.Producer;


@ManagedBean
public final class ExecutorListener implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
       System.out.println("======Context initialized=======");
       //Creating BlockingQueue of size 10
       BlockingQueue<FileMapper> queue = new ArrayBlockingQueue<>(10);
       Producer producer = new Producer(queue);
       Consumer consumer = new Consumer(queue);
       //starting producer to produce messages in queue

       Timer timer = new Timer();
       timer.schedule(new TimerTask() {
    	   public void run() {
    		    new Thread(producer).start();
    		       //starting consumer to consume messages from queue
    		    new Thread(consumer).start();
    	   }
       }, 0, 10000);//10 sec
       
     /*  
       new Thread(producer).start();
       //starting consumer to consume messages from queue
       new Thread(consumer).start();
      */
       System.out.println("Producer and Consumer has been started");
    }
}