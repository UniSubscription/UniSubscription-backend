package az.code.unisubscription.utils;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println(new Date());
    }
}
