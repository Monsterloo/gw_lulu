package com.junlon.web.portal.base;

import sun.nio.ch.ThreadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2018/1/5
 */

public class ExecutorsTest {

    private BlockingQueue blockingQueue = new LinkedBlockingQueue();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1,3,1000,TimeUnit.SECONDS,blockingQueue);


    public void getByAdminOnTime() throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    int random = new Random().nextInt(100)+1;
                    try {
                        Thread.sleep(500);
                        System.out.println(random+"----------队列数: "+blockingQueue.size()+"--------当前活跃线程数:"+executor.getActiveCount());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        executor.execute(thread);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorsTest et = new ExecutorsTest();
        et.getByAdminOnTime();
        et.getExecutor().shutdown();
    }

    public BlockingQueue getBlockingQueue() {
        return blockingQueue;
    }

    public void setBlockingQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
    }
}
