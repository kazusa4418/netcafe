
public class LoginUtils {
    public static LoginStatus isEnabledUser(int customerId, int customerPass) throws FailedDatabaseAccessException{
        return LoginStatus.ENABLED;
    }
}
