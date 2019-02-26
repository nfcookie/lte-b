package com.handler;

import com.entity.Commend;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 任务队列
 */
public class StoreManager {

    private static class SingletonHolder {
        public final static StoreManager instance = new StoreManager();
    }

    public static StoreManager getStoreManager() {
        return StoreManager.SingletonHolder.instance;
    }

    protected final Queue<Commend> queue = new ConcurrentLinkedQueue<>();

    public void add(Commend commend) {
        queue.add(commend);
    }

    public Queue<Commend> getCommendQueue() {
        return queue;
    }

}
