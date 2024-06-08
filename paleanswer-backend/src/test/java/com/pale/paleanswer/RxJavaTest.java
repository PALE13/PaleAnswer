package com.pale.paleanswer;

import io.reactivex.Flowable;

import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RxJavaTest {
    @Test
    public void test() throws InterruptedException {
        //创建数据流
        Flowable<Long> flowable = Flowable.interval(1, TimeUnit.SECONDS)
                .map(i -> i + 1)
                .subscribeOn(Schedulers.io());//指定使用的线程池

        //订阅Flowable数据流，打印出每个接收到的数据
        flowable
                .observeOn(Schedulers.io())
                .doOnNext(System.out::println)
                .subscribe();

        //主线程休眠10秒，等待Flowable数据流执行完毕
        Thread.sleep(10000L);
    }
}
