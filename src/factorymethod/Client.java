package factorymethod;

import factorymethod.book.Book;
import factorymethod.factory.BookFactory;
import factorymethod.factory.HistoryBookFactory;
import factorymethod.factory.ScienceBookFactory;

public class Client {

    public static void main(String[] args) {

        BookFactory bookFactory = new BookFactory() {
            @Override
            public Book createBook() {
                return null;
            }
        };
        bookFactory.orderBook(HistoryBookFactory.getInstance());
        bookFactory.orderBook(ScienceBookFactory.getInstance());

        System.out.println("-------------------------------------");


//        Book historybook = HistoryBookFactory.getInstance().orderBook();
//        System.out.println(historybook);
//
//        Book scienceBook = ScienceBookFactory.getInstance().orderBook();
//        System.out.println(scienceBook);
    }

}
