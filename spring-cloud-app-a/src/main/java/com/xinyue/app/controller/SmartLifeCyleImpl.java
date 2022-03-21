package com.xinyue.app.controller;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;
@Service
public class SmartLifeCyleImpl implements SmartLifecycle{
    private boolean running =false;
    @Override
    public void start() {
        System.out.println("===服务启动成功===");
        running = true;
    }

    @Override
    public void stop() {
        System.out.println("===服务停止成功===");
    }

    @Override
    public boolean isRunning() {
        return running;
    }
    @Override
    public int getPhase() {
        return SmartLifecycle.super.getPhase();
    }

}
