package org.bigwinner.interview.sychornized;

import java.util.concurrent.TimeUnit;

/**
 * @author: bigwinner
 * @date: 2021/4/9 上午10:20
 * @version: 1.0.0
 * @description: 锁测试类1
 * synchronized方法锁是对象锁，只对同一个对象的锁方法生效。不同对象持相同的锁方法互不干扰。
 */
public class Phone1 {
    public synchronized void sendMail() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println(Thread.currentThread().getName() + ":******sendMail******");
    }
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":******sendSMS*******");
    }

    public static void main(String[] args) throws InterruptedException {
        Phone1 phone = new Phone1();
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

        Phone1 phone1 = new Phone1();
        new Thread(()->{
            try {
                phone1.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();
    }
}
