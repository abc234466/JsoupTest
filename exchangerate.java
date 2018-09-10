package stock;

public class exchangerate {
	private String country;
	private String buyrate;
	private String sellrate;

	public exchangerate(){
	}

	public void setcountry(String country){
		this.country = country;
	}

	public void setbuyrate(String buyrate) {
		this.buyrate = buyrate;
	}

	public void setsellrate(String sellrate) {
		this.sellrate = sellrate;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "[\"" + country + "\",\"" + buyrate + "\", \"" + sellrate +"\"]";
//				["USA","Metro City","2016"]

	}
}
