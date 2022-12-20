import java.util.Date;

public class Post {
  private String title;
  private Date date;
  private String content;
  private int likes;
  private int dislikes;

  public Post(String title, String content) {
    this.title = title;
    this.date = new java.util.Date();
    this.content = content;
    this.likes = 0;
    this.dislikes = 0;
  }

  public void show() {
    System.out.println("Title: " + this.title);
    System.out.println("Date: " + this.date);
    System.out.println("");
    System.out.println(this.content);
    System.out.println("Likes <" + this.likes + ">" + " Dislikes <" + this.dislikes + ">");
  }

  public void like() {
      this.likes += 1;
  }

  public void dislike() {
      this.dislikes += 1;
	}

  // getters and setters

  public void setTitle(String title) {
      this.title = title;
  }
  public String getTitle() {
      return this.title;
  }
  public void setContent(String content) {
      this.content = content;
  }
  public void setLike(boolean like) {
      if (like) this.likes += 1;
  }
  public void setDislike(boolean dislike) {
      if (dislike) this.dislikes += 1;
  }
}
