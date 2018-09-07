import java.util.*;

public class Front {
    public static void main(String[] args) {
        //BoothManagerの起動
        BoothManager boothManager = BoothManager.getInstance();
        Scanner sc = new Scanner(System.in);

        //ログイン処理
        System.out.println("会員番号を入力してださい");
        int customerId = Integer.parseInt(sc.nextLine());
        System.out.println("パスワードを入力してください");
        int customerPass = Integer.parseInt(sc.nextLine());
        //不正なパスワードでないか検査する


        isEnable(customerPass);

        Login(customerId, customerPass);

        //空き部屋を表示するための処理
        Booth unusedRooms [] = boothManager.getUnusedRooms();
        for(Booth booth: unusedRooms){
            System.out.print(booth.getBoothNo() + " ");
        }

        //空室状況の問い合わせ
        System.out.println("お部屋を選択してください");
        String boothNum = sc.nextLine();

        //部屋の割当の確定処理
        boothManager.setStatus(boothNum);
        System.out.println("お客様のお部屋は" + boothNum + "になります");
    }

    private static boolean isEnable(int customerPass){
        if (String.valueOf(customerPass).length() >= 30){
         System.out.println("不正な値が入力されました");

        }

        return true;
    }

    private static void Login(int customerId, int customerPass) {
        try {
             LoginStatus isEnabled = LoginUtils.isEnabledUser(customerId, customerPass);
             if (isEnabled.equals(LoginStatus.ENABLED)){
                 System.out.println("お客様情報の確認がとれました");
             }else {
                 checkErrorStatus(isEnabled);
                 System.exit(0);
             }
        } catch (FailedDatabaseAccessException e) {

        }
    }

    private static void checkErrorStatus(LoginStatus errorLog){
        if (errorLog.equals(LoginStatus.EXPIRED)){
            System.out.println("お客様情報の有効期限が切れております");
            System.out.println("従業員をお呼びのうえ、お客様情報の更新をお願いします");
        }else{
            System.out.println("お客様情報が正しく読み込めませんでした");
            System.out.println("大変恐れ入りますが、最初の画面からもう一度お願いします");
        }
    }
}