package com.tenoke.cloud.web.config;

import com.tenoke.cloud.core.exceptions.CustomAsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author jerrylau
 */
@Configuration
@EnableAsync
public class AsyncExecutorConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        //线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量
        taskExecutor.setCorePoolSize(5);
        //线程池维护线程的最大数量
        taskExecutor.setMaxPoolSize(200);
        //线程池所使用的缓冲队列
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }
}
