import java.util.ArrayList;
import java.util.List;

public class BoothManager {
    /* =============== SINGLETON =============== */
    private static BoothManager instance = new BoothManager();

    public static BoothManager getInstance() {
        return instance;
    }
    /* ========================================= */

    private List<Booth> boothList = new ArrayList<>();

    private BoothManager() {
        for (int i = 1; i < 16; i++ ) {
            boothList.add(new Booth(Status.UNUSED, "S-" + String.format("%04d", i)));
        }
    }

    Booth[] getUnusedRooms() {
        ArrayList<Booth> list = new ArrayList<>();

        for (Booth booth : boothList) {
            if (booth.isUnused()) {
                list.add(booth);
            }
        }
        return list.toArray(new Booth[16]);
    }

    void setStatus(String boothNo) {
        for (Booth booth : boothList) {
            if (booth.getBoothNo().equals(boothNo)) {
                booth.setStatus(Status.USED);
                //お客様を引数に与えられた部屋にセットする
                booth.setCustomer(new Customer());
            }
        }
    }
}
