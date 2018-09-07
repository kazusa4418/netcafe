public class FailedDatabaseAccessException extends Exception {
    private int errorId;

    FailedDatabaseAccessException(int errorId, String errMsg) {
        super(errMsg);
        this.errorId = errorId;
    }

    int getErrorId() {
        return errorId;
    }
}
