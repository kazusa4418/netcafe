
public class LoginUtils {
    public static LoginStatus isEnabledUser(String customerId, String customerPass) throws FailedDatabaseAccessException{
        return LoginStatus.ENABLED;
    }
}
