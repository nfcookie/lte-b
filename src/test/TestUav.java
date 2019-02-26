import com.entity.Commend;
import com.handler.Processer;
import com.handler.StoreManager;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.utils.Utils.getNow;

public class TestUav {

    private static Logger logger = LoggerFactory.getLogger(TestUav.class);

    @Test
    public void initTask() {

        for (int i = 1; i < 3; i++) {

            Commend commend = new Commend();
            commend.setTaskId(i);
            commend.setActionType("createTask");
            commend.setCompletedTime("2019-2-26 21:07:01");
            commend.setDeliveryAddress("someone");
            commend.setStartTime(getNow());
            commend.setDroneName("droneName");
            commend.setVersion("1");

            StoreManager.getStoreManager().add(commend);
        }


        //线程启动
        Processer processer = new Processer();
        processer.setIntervalTime(5 * 1000L);   //制定执行的间隔
        processer.start();

        int i = 0;
        while (!Processer.end) {
            try {

            } catch (Exception e) {
            }
        }

        System.out.println("任务已执行完成");
    }
}
