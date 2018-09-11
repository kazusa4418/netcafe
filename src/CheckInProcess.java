import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.*;
import java.io.File;
import java .util.List;

public class CheckInProcess {
    private static final String DATABASE_SERVER_IP = "118.17.18.109";
    private static final int DATABASE_SERVER_PORT = 3306;


    public static void main(String[] args) {
        // カードないからキーボードで変わりにuser_idを取得する
        System.out.print("user_id > ");
        String user_id = new Scanner(System.in).nextLine();

        System.out.println("データベースサーバーにアクセスしています...");
        MySqlServer database_server = connectServer("")
    }

    private static Socket connectServer(String host, int port) throws IOException {
        return new Socket(host, port);
    }
}