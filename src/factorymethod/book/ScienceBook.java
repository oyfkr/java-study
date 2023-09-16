package factorymethod.book;

public class ScienceBook extends Book{

    public ScienceBook(String name, int page) {
        super(name, page);
        this.type = "과학";
    }
}
