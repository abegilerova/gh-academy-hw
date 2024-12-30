package java_hw.week11;

public class Book {
    int id;
    String title;
    String author;
    double price;
    double rating;

    public Book (int id, String title, String author, double price, double rating){
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.rating = rating;
    }

    public double getPrice(){
        return price;
    }

    public String getTitle(){
        return title;
    }

    public Double getRating(){
        return rating;
    }

    public String getAuthor(){
        return author;
    }

    @Override
    public String toString(){
        return "Book id is " + id + " ,title is " + title + " ,author is " + author + " ,price is " + price + " ,rating is "+ rating;
    }
}
