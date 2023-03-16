package com.tuling.jucdemo.lock;

import java.util.concurrent.CountDownLatch;

/**
 * 让多个线程等待：模拟并发，让并发线程一起执行
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("准备执行……");
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    //准备完毕……运动员都阻塞在这，等待号令
                    int s = finalI * 1000;
                    Thread.sleep(s);
                    String parter = "【" + Thread.currentThread().getName() + "】";
                    countDownLatch.countDown();// 发令枪：执行发令
                    System.out.println(parter + "开始执行……");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        //  Thread.sleep(2000);// 裁判准备发令

    }
}

