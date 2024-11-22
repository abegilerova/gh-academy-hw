package java_hw.week9;

import java.util.Random;

class User implements Runnable {

    private Library library;
    private String[] bookTitles;
    private Random random = new Random();

    public User (Library library, String[] bookTitles){
        this.library = library;
        this.bookTitles = bookTitles;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            String title = bookTitles[random.nextInt(bookTitles.length)];
            Book book = library.getBookByTitle(title);
            int action = random.nextInt(2);

            if(action == 0){
                book.checkOut();
            } else {
                book.returnBook();
            }

            try {
                Thread.sleep(100);

            } catch(InterruptedException e){
                System.out.println("Transaction interrupted");

            }

        }
    }
}
