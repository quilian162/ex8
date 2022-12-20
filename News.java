public class News extends Post{
	private String source;

  public News (String title, String content, String source) {
      super(title, content);
      this.source = source;
  }

  @Override
	public void show() {
      super.show();
      System.out.println("Source: " + this.source);

	}
  public void setSource (String source) {
      this.source = source;
  }
}
