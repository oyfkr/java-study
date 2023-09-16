package factorymethod.factory;

import factorymethod.book.Book;

public abstract class BookFactory {

    public Book orderBook(BookFactory bookFactory) {

        Book book = bookFactory.createBook();
        complete();

        return book;
    }

    abstract public Book createBook();

    private void complete() {
        System.out.println("다 만들었으니깐 교육청에 신고할게요~!~");
    }
}
