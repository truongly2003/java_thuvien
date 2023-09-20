package DTO;
public class BookShelfDTO {
    private int bookshelfid;
    private String location;

    public BookShelfDTO(int bookshelfid, String location) {
        this.bookshelfid = bookshelfid;
        this.location = location;
    }

    public BookShelfDTO() {
    }

    public int getBookshelfid() {
        return bookshelfid;
    }

    public void setBookshelfid(int bookshelfid) {
        this.bookshelfid = bookshelfid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "BookShelf{" + "bookshelf=" + bookshelfid + ", location=" + location + '}';
    }
    
}
