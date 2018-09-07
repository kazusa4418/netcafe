import java.util.Date;

class Customer {
    private Date enteredTime;    //入店時刻

    Customer() {
        enteredTime = new Date();
    }

    Date getEnteredTime(){
        return enteredTime;
    }

    Date getExitTime(){
        return new Date();       //退店時刻
    }

}
