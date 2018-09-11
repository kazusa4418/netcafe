import java.util.Date;

class Customer {
    private Date enteredTime;    //入店時刻
    String customerId;           //会員番号

    Customer(String customerId) {
        this.customerId = customerId;
        enteredTime = new Date();
    }

    Date getEnteredTime(){
        return enteredTime;
    }

    Date getExitTime(){
        return new Date();       //退店時刻
    }

    String getCustomerId(){
        return customerId;
    }
}
