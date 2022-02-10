package org.bigwinner.interview.optional;

import java.util.Optional;

/**
 * @author: IT大狮兄
 * @date: 2022/2/10 上午10:19
 * @version: 1.0.0
 * @description: Optition类的作用
 */
public class OptionalTest {
    public static void main(String[] args) {
        Integer value1 = new Integer(12);
        Integer value2 = null;

        // 包装成Optitionnal类
        // of()方法参数不能为null，否则会报空指针
//        Optional a = Optional.of(value2);
        Optional a = Optional.of(value1);
        // ofNullable()可以传入null参数 TODO: 避免空指针异常
        Optional b = Optional.ofNullable(value2);
        // get()方法的调用者必须值存在，即不能为null，否则会报NoSuchElementException
//        System.out.println(b.get());
        // orElse()方法，如果只存在则返回它；如果值不存在，则返回默认值 TODO: 避免了NoSuchElementException
        System.out.println(b.orElse(11));
        System.out.println(a.orElse(11));
    }
}
