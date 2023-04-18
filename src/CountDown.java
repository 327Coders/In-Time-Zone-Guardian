
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CountDown {
    public int getLimitSec() {
        return this.limitSec;
    }

    public int getCurSec() {
        return this.curSec;
    }

    private int limitSec;
    private int curSec;

    public CountDown(int limitSec) throws InterruptedException {
        this.limitSec = limitSec;
        this.curSec = limitSec;
        System.out.println("count down from " + limitSec + " s ");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("Time remians " + --curSec + " s");
            }
        }, 0, 1000);
        TimeUnit.SECONDS.sleep(limitSec);
        timer.cancel();
        System.out.println("Time is out!");
    }
}
    //Test
/*	public static void main(String[] args) throws InterruptedException{
		new CountDown2(10);
	}*/
