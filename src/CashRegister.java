import java.util.concurrent.TimeUnit;

public class CashRegister {

    private static long getUsedTime(Booth usedBooth){
        //指定された部屋のお客様を受け取る
        Customer usedCustomer = usedBooth.getCustomer();

        return TimeUnit.MILLISECONDS.toSeconds(usedCustomer.getEnteredTime().getTime() - usedCustomer.getExitTime().getTime());
    }
}


