import java.util.*;

public class Front {
    public static void main(String[] args) {
        //BoothManagerの起動
        BoothManager boothManager = BoothManager.getInstance();
        Scanner sc = new Scanner(System.in);
        //会員情報の受付
        System.out.println("会員番号を入力してださい");
        int customerId = Integer.parseInt(sc.nextLine());
        System.out.println("パスワードを入力してください");
        int customerPass = Integer.parseInt(sc.nextLine());
        Front.Login(customerId, customerPass);
        //空室状況の問い合わせ

        System.out.println("お部屋を選択してください");
        String roomNum = sc.nextLine();
        boothManager.setStatus(roomNum, Status.USED);
        System.out.println("お客様のお部屋は" + roomNum + "になります");
    }

    boolean Login(int customerId, int customerPass) {

        try {
            boolean isEnabled = LoginUtils.isEnabledUser(customerId, customerPass);
            if (isEnabled) {
                System.out.println("お客様情報が確認できました。");
            } else {
                //LoginStatusにより分岐する
                if()
            }
        } catch (FailedDatabaseAccessException e) {
            System.out.println();
        }

        return loginStatus;
    }

}