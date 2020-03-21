package com.sdww8591.webflux;

import reactor.core.publisher.Mono;

public class Demo {

    private void task1(Wrapper input) {
        input.value = input.value + 1;
    }

    private void task2(Wrapper input) {
        input.value = input.value - 1;
    }

    //同步编程
    public void sync(Wrapper src) {
        task1(src);
        task2(src);
        //其他操作
    }

    //异步编程
    //先把执行方案编排（串起来），等到满足条件就执行
    public Mono<?> async(Mono<Wrapper> src) {
        return src.doOnNext(this::task1)
                .doOnNext(this::task2)
                .then();
    }

    class Wrapper {
        Integer value;
    }
}
