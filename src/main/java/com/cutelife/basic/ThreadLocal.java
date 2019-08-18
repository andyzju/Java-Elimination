package com.cutelife.basic;

/**
 * Description:
 * <i>明白ThreadLocal是属于某个线程的即可</i>
 * <i>不同的线程可以拥有同一个threadlocal的key，但是其值却不同</i>
 * <i>ThreadLocal是属于线程的，每个线程有一个threalocals，它是一个ThreadLocalMap(属于线程)</i>
 * <i>每个线程操作threadlocal时候，实际上是去获取该线程的ThreadLocalMap值，然后从ThreadLocalMap中获取改threadlocal的value值</i>
 * <i>每一个 Thread 中都保存着自己的一个 ThreadLocalMap</i>
 *
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-06-02
 * Time: 上午1:28
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class ThreadLocal {
}
