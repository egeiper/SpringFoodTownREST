package props;

public class CartPro {
	private Integer cartid;
	private String foodname;
	private double foodprice;
	private String foodstatus;
	public Integer getCartid() {
		return cartid;
	}
	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public double getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(double foodprice) {
		this.foodprice = foodprice;
	}
	public String getFoodstatus() {
		return foodstatus;
	}
	public void setFoodstatus(String foodstatus) {
		this.foodstatus = foodstatus;
	}
}
