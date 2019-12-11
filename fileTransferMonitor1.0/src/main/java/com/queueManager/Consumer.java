package com.queueManager;

import java.io.File;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

private BlockingQueue<FileMapper> queue;
    
    public Consumer(BlockingQueue<FileMapper> q){
        this.queue=q;
    }

    @Override
    public void run() {
    	  System.out.println("==========consumption Started AT:"+new Date());
        try{
        	FileManager fmanager=new FileManager();
        	while(!queue.take().isLastFile()) {
        		FileMapper fm=queue.take();
        		
                System.out.println("Consumed "+fm.getFile().getName());
                fmanager.moveFile(fm.getFile());
        	}
    		FileMapper fm=queue.take();   // last file
            System.out.println("Consumed "+fm.getFile().getName());
            fmanager.moveFile(fm.getFile());
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}