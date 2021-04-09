package org.bigwinner.interview.sychornized;

import java.util.concurrent.TimeUnit;

/**
 * @author: bigwinner
 * @date: 2021/4/9 上午10:21
 * @version: 1.0.0
 * @description: 锁测试类2
 * static synchronized方法锁是类锁，对该类的所有对象都生效，下一个对象执行锁方法必须要等待上一个锁释放才可以执行。
 */
public class Phone2 {
    public static synchronized void sendMail() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println(Thread.currentThread().getName() + ":******sendMail******");
    }
    public static synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":******sendSMS*******");
    }

    public static void main(String[] args) throws InterruptedException {
        Phone2 phone = new Phone2();
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

        Phone2 phone2 = new Phone2();
        new Thread(()->{
            try {
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

        Phone2 phone1 = new Phone2();
        new Thread(()->{
            try {
                phone1.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"D").start();
    }
}
