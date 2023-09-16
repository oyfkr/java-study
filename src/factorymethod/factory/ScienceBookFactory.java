package factorymethod.factory;

import factorymethod.book.Book;
import factorymethod.book.ScienceBook;

public class ScienceBookFactory extends BookFactory{

    public static class SingleInstanceHolder {
        private static final ScienceBookFactory INSTANCE = new ScienceBookFactory();
    }

    public static ScienceBookFactory getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    @Override
    public ScienceBook createBook() {
        System.out.println("과학책 만드는 중~");
        return new ScienceBook("과학책", 100);
    }
}
