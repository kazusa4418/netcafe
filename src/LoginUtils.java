import mysql.MySql;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoginUtils {
    private static final String SELECT_SENTENCE = "SELECT * FROM user WHERE user_id = $user_id and password = $password";

    public static LoginStatus isEnabledUser(String userId, String password) throws FailedDatabaseAccessException {
        try (MySql mysql = new MySql()) {
            try {
                ResultSet resultSet = mysql.executeQuery(SELECT_SENTENCE.replace("$user_id", userId)
                                                                        .replace("$password", password));

                // SELECT文で取得できたレコードが0行だったらそのIDとPASSWORDを持つユーザーはいない
                if (!resultSet.next()) {
                    return LoginStatus.UNMATCHED;
                }

                // ユーザーの有効期限を照会する
                Date goodThrough = resultSet.getDate("good_through");
                // 有効期限が切れていなければそのユーザーは有効
                boolean isExpired = goodThrough.toLocalDate().isAfter(LocalDate.now());
                return isExpired ? LoginStatus.EXPIRED : LoginStatus.ENABLED;
            }
            catch (SQLException err) {
                throw new FailedDatabaseAccessException(2, "SELECT文の実行に失敗しました");
            }
        }
        catch (SQLException err) {
            throw new FailedDatabaseAccessException(1, "データベースへのアクセスに失敗しました");
        }
    }
}
