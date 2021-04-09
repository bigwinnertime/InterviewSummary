package org.bigwinner.interview.sychornized;

import java.util.concurrent.TimeUnit;

/**
 * @author: bigwinner
 * @date: 2021/4/9 上午10:21
 * @version: 1.0.0
 * @description: 锁测试类3
 */
public class Phone3 {
    public static synchronized void sendMail() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println(Thread.currentThread().getName() + ":******sendMail******");
    }
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":******sendSMS*******");
    }

    public static void main(String[] args) throws InterruptedException {
        Phone3 phone = new Phone3();
        new Thread(()->{
            try {
                phone.sendMail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
        Thread.sleep(1000);
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

        Phone3 phone1 = new Phone3();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

        Phone3 phone2 = new Phone3();
        new Thread(()->{
            try {
                phone.sendMail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"D").start();
    }
}
