import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class Blog {
	private ArrayList<Post> posts = new ArrayList<Post>();

	public void showAll() {
      for (Post i : posts) {
          System.out.println("------------------------------------------------------------------");
          if (i instanceof News) ((News)i).show();
          else if (i instanceof ProductReview) ((ProductReview)i).show();
          else i.show();
          System.out.println("------------------------------------------------------------------");
      }
	}

	public void readData(Post p) throws RuntimeException {
      Scanner rd = new Scanner(System.in);
      String title, content, source, brand;
      int stars;

      System.out.print("Title: ");
      title = rd.nextLine();
      for (Post i : posts) {
          if (i.getTitle().equals(title)) throw new RuntimeException("Title must be unique");
      }
      System.out.print("Content: ");
      content = rd.nextLine();
      
      p.setTitle(title);
      p.setContent(content);

      if (p instanceof News) {
          System.out.print("Source: ");
          source = rd.nextLine();
          ((News)p).setSource(source);
      } else if (p instanceof ProductReview) {
          System.out.print("Brand: ");
          brand = rd.nextLine();
          stars = -1;
          while (stars > 10 || stars < 0) {
              System.out.print("Stars: (must range from 1 to 10) ");
              stars = rd.nextInt();
              if (stars > 10 || stars < 0) continue;
          }
          ((ProductReview)p).setBrand(brand);
          ((ProductReview)p).evaluate(stars);
      }
      this.posts.add(p);
  }

  public static void main(String[] args) {
      Scanner rd = new Scanner(System.in);
      int choice;
      String msg;
      Blog b = new Blog();
      while (true) {
          System.out.print(
                  "BLOG: O que voce quer fazer?\n\n"+
                  "1 - Novo post de noticia\n"+
                  "2 - Nova resenha de produto\n"+
                  "3 - Novo post de outros assuntos\n"+
                  "4 - Listar todas as postagens\n"+
                  "5 - Curtir uma postagem\n"+
                  "6 - Nao Curtir uma postagem\n"+
                  "10 - Sair\n"+
                  "Escolha a opcao:"
                  );
          try {
              choice = rd.nextInt();
          } catch (InputMismatchException e) {
              System.out.println("Must enter an Integer value for a new Action");
              rd.next();
              continue;
          }
          switch(choice) {
              case 1:
                try {
                    Post p = new News("title", "content", "source");
                    b.readData(p);
                } catch (RuntimeException e) {
                    System.out.println(e);
                }
                break;
              case 2:
                try {
                    Post o = new ProductReview("title", "content", "brand");
                    b.readData(o);
                } catch (RuntimeException e) {
                    System.out.println(e);
                }
                break;
              case 3:
                try {
                    Post t = new News("title", "content", "source");
                    b.readData(t);
                } catch (RuntimeException e) {
                    System.out.println(e);
                }
                break;
              case 4:
                b.showAll();
                break;
              case 5:
                msg = (b.posts.size() > 0) ? "(Available posts range from id 1 to "+ (b.posts.size()) +")" : "Still doesnt have posts";
                System.out.println("Enter post's ID: " + msg);
                try {
                    choice = rd.nextInt();
                    b.posts.get(choice-1).like();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid ID. Post does not exists!");
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid Entry. Just Integer values are valid!");
                    rd.next();
                }
                break;
              case 6:
                msg = (b.posts.size() > 0) ? "(Available posts range from id 1 to "+ (b.posts.size()) +")" : "No available posts";
                System.out.println("Enter post's ID: " + msg);
                try {
                    choice = rd.nextInt();
                    b.posts.get(choice-1).dislike();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid ID. Post does not exists!");
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid Entry. Just Integer values are valid!");
                    rd.next();
                }
                break;
              case 10:
                System.exit(0);
                break;
          }
      }
   }
}
