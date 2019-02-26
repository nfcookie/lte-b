package com.handler;

import com.alibaba.fastjson.JSONObject;
import com.entity.Commend;
import com.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;

import static com.utils.Utils.getNow;
import static com.utils.Utils.isLater;

public class Processer extends Thread {

    private static Logger logger = LoggerFactory.getLogger(Processer.class);

    private long intervalTime = 0L;

    boolean _isRunning = true;

    public static boolean end = false;

    public void setIntervalTime(long intervalTime) {
        this.intervalTime = intervalTime;
    }

    @Override
    public void run() {
        while (_isRunning) {
            try {
                if (!process()) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                logger.error("执行无人机任务异常:" + e.toString());
            }
        }
    }

    private boolean process() {
        boolean b = false;
        try {
            //开始执行
            Queue<Commend> queue = StoreManager.getStoreManager().getCommendQueue();

            while (!queue.isEmpty()) {
                Commend commend = queue.poll();
                boolean timeOver = false;

                while (true) {

                    Integer taskId = commend.getTaskId();

                    //执行结束时间是否小于当前时间
                    if (isLater(getNow(), commend.getCompletedTime())) {
                        System.out.println("taskId:" + taskId + "已超过结束时间，停止");
                        break;
                    }

                    String actionType;
                    if (Math.random() < 0.5) {               //随机数执行createTask或执行queryTask
                        actionType = "createTask";
                    } else {
                        actionType = "queryTask";
                    }

                    logger.info("时间:{},taskId:{},请求:{}", getNow(), commend.getTaskId());
                    System.out.println("taskId:" + taskId + ",执行了一次：" + actionType + "时间为" + getNow());
                    String url = "http://127.0.0.1:8081/nbi/deliverytask?id=" + commend.getTaskId();

                    try {
                        JSONObject returnData = HttpHelper.httpPost(url, commend);
                        if (returnData == null) {
                            logger.error("网关无响应");
                        } else if (returnData.getInteger("code") == -1) {
                            logger.error("网关请求异常：{}", returnData.getString("msg"));
                        }
                    } catch (Exception e) {
                        logger.error("服务请求异常");
                    }
                    Thread.sleep(this.intervalTime);        //每次间隔执行的时间
                }
            }
            end = true;
            b = true;
        } catch (Exception e) {
            logger.error("执行无人机请求异常:" + e.toString());
        }
        return b;
    }


}
