package Lab8;

public class Book {
    private String isbn;
    private String author;
    private String title;
    private String year;

    public Book(String isbn_, String author_, String title_,String year_){
        isbn = isbn_;
        author = author_;
        title = title_;
        year = year_;
    }
    public String getIsbn(){

        return isbn;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getTitle(){

        return title;
    }

    public String getYear() {

        return year;
    }
}
