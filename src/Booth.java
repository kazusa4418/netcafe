public class Booth {
	//部屋のステータス
	private Status status;
	//部屋番号
	private final String boothNo;
	//使用しているお客様情報
	private Customer customer;
	
	Booth(Status status, String boothNo){
		this.status = status;
		this.boothNo = boothNo;
	}

	//部屋が使うことができるのか
	public boolean isUnused(){
		return status == Status.UNUSED;
	}

	//ステータスの更新時
	public void setStatus(Status status){
		this.status = status;
	}

	//お客様を部屋にセットする
	void setCustomer(Customer customer){this.customer = customer;}

	String getBoothNo() {
	    return boothNo;
    }

    public String toString() {
	    return boothNo + " " + status;
    }

    Customer getCustomer(){
		return this.customer;
	}
}