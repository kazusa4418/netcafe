import java.util.*;

public class Front {
    public static void main(String[] args) {
        //BoothManagerの起動
        BoothManager boothManager = BoothManager.getInstance();
        Scanner sc = new Scanner(System.in);

        //入力を受け付ける
        System.out.println("会員番号を入力してださい");
        String customerId = sc.nextLine();
        System.out.println("パスワードを入力してください");
        int customerPass = Integer.parseInt(sc.nextLine());

        //不正なパスワードでないか検査する
        boolean isEnabledPass;
        do {
            isEnabledPass = isEnable(customerPass);
        }while (!(isEnabledPass));

        //ログインする
        Login(customerId, customerPass);

        //----------ログインが成功した時のみこの先に進める------------------------------------------------------


        //空き部屋を表示するための処理
        Booth unusedRooms [] = boothManager.getUnusedRooms();
        for(Booth booth: unusedRooms){
            System.out.print(booth.getBoothNo() + " ");
        }

        //空室状況の問い合わせ
        System.out.println("\n以上の中からお部屋を選択してください");
        String boothNum = sc.nextLine();

        //部屋の割当の確定処理
        boothManager.setStatus(boothNum);
        System.out.println("お客様のお部屋は" + boothNum + "になります");
    }

    private static boolean checkIdEnable (String customerId){
        if (customerId.contains())
    }

    private static boolean checkPassEnable (int customerPass){
        if (String.valueOf(customerPass).length() >= 30){
         System.out.println("不正な値が入力されました");
         return false;
        }
        return true;
    }

    private static void Login(String customerId, int customerPass) {
        try {
             LoginStatus isEnabled = LoginUtils.isEnabledUser(customerId, customerPass);
             if (isEnabled.equals(LoginStatus.ENABLED)){
                 System.out.println("お客様情報の確認がとれました");
             }else {
                 checkErrorStatus(isEnabled);
                 System.exit(0);
             }
        } catch (FailedDatabaseAccessException e) {
            switch (e.getErr()){
                case 1:
                    System.out.println("エラーコード:" + e.getErr());
                    System.out.println("アクセスエラーです。従業員をお呼びください");
                case 2:
                    System.out.println("エラーコード:" + e.getErr());
                    System.out.println("重大なエラーが発生しました。サーバー管理者に問い合わせてください");
            }
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