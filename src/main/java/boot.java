import com.handler.Processer;

public class boot {
    public static void main(String[] args) {
        System.out.println(123);

        //线程启动
        Processer processer = new Processer();
        processer.setIntervalTime(5 * 1000L);
        processer.start();
    }
}
