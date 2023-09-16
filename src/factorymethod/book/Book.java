package factorymethod.book;

public class Book {

    String name;
    int page;
    String type;

    public Book(String name, int page) {
        this.name = name;
        this.page = page;
    }

    @Override
    public String toString() {
        return String.format("name : '%s', page : '%s', type : '%s'", name, page, type);
    }

}
