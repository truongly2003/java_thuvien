package DTO;
public class BookCategoryDTO {
    private int categoryid;
    private String categoryname;
    private int status;

    public BookCategoryDTO(int categoryid, String categoryname) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
    }

    public BookCategoryDTO() {
    }

    public BookCategoryDTO(int categoryid, String categoryname, int status) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.status = status;
    }

 
    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryName() {
        return categoryname;
    }

    public void setCategoryName(String categoryname) {
        this.categoryname = categoryname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return categoryid + "-" + categoryname;
    }

    
}
