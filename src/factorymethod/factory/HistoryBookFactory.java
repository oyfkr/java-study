package factorymethod.factory;

import factorymethod.book.Book;
import factorymethod.book.HistoryBook;

public class HistoryBookFactory extends BookFactory{

    private static class SingleInstanceHolder {
        private static final HistoryBookFactory INSTANCE = new HistoryBookFactory();
    }

    public static HistoryBookFactory getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    @Override
    public HistoryBook createBook() {
        System.out.println("역사책 만드는 중~");
        return new HistoryBook("역사책", 100);
    }
}
