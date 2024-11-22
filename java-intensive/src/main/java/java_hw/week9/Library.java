package java_hw.week9;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public Book getBookByTitle(String title){
        for (Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }

    public void displayAvailableBooks(){
        for (Book book : books){
            if(book.getAvailable()){
                System.out.println("Book title is " + book.getTitle());
            }
        }
    }
}
