package factorymethod.book;

public class HistoryBook extends Book{

    public HistoryBook(String name, int page) {
        super(name, page);
        this.type = "역사";
    }
}
