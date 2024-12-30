package java_hw.week11;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BookManagementSystem {
    public static void main (String[] args) {
        List<Book> booksData = List.of(
                new Book(1, "AikaBook", "AikaBegi", 100.0, 4.5),
                new Book(1, "BekaBook", "BekaBegi", 2.0, 1.5),
                new Book(1, "AidanBook", "AidanBegi", 3.0, 5.5));


        Predicate<Book> ratingsHigherThan4 = n -> n.rating > 4.0;
        List<Book> filteredBooks = filterBooksByRatings(booksData, ratingsHigherThan4);
        filteredBooks.forEach(book -> System.out.println(book));

        //find 3 most expensive books
         List<Book> mostExpensiveBooks = sortBooksByPrice(booksData);
        mostExpensiveBooks.forEach(book -> System.out.println(book));

        //transformTitles
        List<String> transformedTitles = transformTitles(booksData);
        transformedTitles.forEach(System.out::println);

        //Sort by Rating and Price: Sort books first by rating (descending) and then
        //by price (ascending).

        Map<String, List<Book>> booksByPriceRange = booksByPriceRange(booksData);
        booksByPriceRange.forEach((range,bookList) -> {
            System.out.println(range + ":");
            bookList.forEach(System.out::println);
        });

    }
    public static List<Book> filterBooksByRatings(List<Book> books, Predicate<Book> condition){
        return books.stream().filter(condition).collect(Collectors.toList());

    }

    public static List<Book> sortBooksByPrice(List<Book> books){
        return books.stream().sorted(Comparator.comparingDouble(Book::getPrice).reversed()).limit(3)
                .collect(Collectors.toList());
    }

    public static List<String> transformTitles(List<Book>books){
        return books.stream().map(book -> book.getTitle().toUpperCase()).collect(Collectors.toList());
    }

    public static List<Book> sortByRatingAndPrice(List<Book>books) {
        return books.stream().sorted(Comparator.comparingDouble(Book::getRating).reversed().
                thenComparingDouble(Book::getPrice)).collect(Collectors.toList());

    }

    public static Map<String, Double> averagePriceByAuthor(List<Book>books){
        return books.stream().collect(Collectors.groupingBy(book -> book.author,Collectors.averagingDouble(Book::getPrice)));
    }

    public static Map<String, List<Book>> booksByPriceRange (List<Book>books){
        return books.stream().collect(Collectors.groupingBy(book -> {
            if(book.price < 20) return "<$20";
            else if(book.price<=50) return "$20-$50";
            else  return ">$50";
        }));
    }
}
