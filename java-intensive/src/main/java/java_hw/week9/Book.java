package java_hw.week9;

public class Book {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    int id;
    private String title;
    private String author;
    private Boolean isAvailable = true;

    public Book (int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public boolean checkOut(){
        if (isAvailable){
            isAvailable = false;
            System.out.println("Book checked out: " + title);
        }
        System.out.println("Book is not available: " + title);
        return false;
    }

    public void returnBook(){
        isAvailable = true;
        System.out.println("Book was returned: " + title);
    }
}
