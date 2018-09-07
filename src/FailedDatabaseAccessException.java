
public class FailedDatabaseAccessException extends Exception{
    int err;
    FailedDatabaseAccessException(int i, String s){
        super(s);
        this.err = i;
    }

    public int getErr(){
        return err;
    }
}
