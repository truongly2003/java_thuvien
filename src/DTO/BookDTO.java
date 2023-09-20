package DTO;
public class BookDTO {
    private int bookid;
    private String bookname;
    private int categoryid;
    private int authorid;
    private int publishid; 
    private int publishyear;
    private int quantity;
    private String image;
    private String status;
    private int bookshelfid;

    public BookDTO(int bookid, String bookname, int categoryid, int authorid, int publishid, int publishyear, int quantity, String image, String status, int bookshelfid) {
        super();    
        this.bookid = bookid;
        this.bookname = bookname;
        this.categoryid = categoryid;
        this.authorid = authorid;
        this.publishid = publishid;
        this.publishyear = publishyear;
        this.quantity = quantity;
        this.image = image;
        this.status = status;
        this.bookshelfid = bookshelfid;
    }

    public BookDTO() {
        super();
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public int getPublishid() {
        return publishid;
    }

    public void setPublishid(int publishid) {
        this.publishid = publishid;
    }

    public int getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(int publishyear) {
        this.publishyear = publishyear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBookshelfid() {
        return bookshelfid;
    }

    public void setBookshelfid(int bookshelfid) {
        this.bookshelfid = bookshelfid;
    }

    

}
