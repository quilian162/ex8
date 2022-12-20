public class ProductReview extends Post implements Evaluable{
	private String brand;
	private int stars;

  public ProductReview(String title, String content, String brand) {
      super(title, content);
      this.brand = brand;
      this.stars = 0;
  }
	@Override
	public void show() {
    super.show();
		System.out.println("Brand: " +this.brand);
		System.out.println("Stars: " +this.stars);
	}

	public void evaluate(int value) {
		this.stars = value;
	}
	
  public void setBrand(String brand) {
      this.brand = brand;
  }
}
