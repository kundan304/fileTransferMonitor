package com.queueManager;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<FileMapper> queue;
    
    public Producer(BlockingQueue<FileMapper> q){
        this.queue=q;
    }
    @Override
    public void run() {

        try {
	        FileManager fm=new FileManager();
			List<FileMapper> fileListAtThisTime=fm.getFileListAtThisTime();
	        System.out.println("==========Production Started AT:(Total Number Of File:"+fileListAtThisTime.size()+") At:"+new Date());
	        for(FileMapper fmapper:fileListAtThisTime) {
	        	queue.put(fmapper);
	        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}