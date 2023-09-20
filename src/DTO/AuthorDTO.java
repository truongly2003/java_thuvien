package DTO;
public class AuthorDTO {
    private int authorid;
    private String authorname;
    private int birth;
    private String hometown;
    public AuthorDTO() {
    }
    public AuthorDTO(int authorid, String authorname, int birth, String hometown) {
        this.authorid = authorid;
        this.authorname = authorname;
        this.birth = birth;
        this.hometown = hometown;
       
    }

    public AuthorDTO(int authorid, String authorname) {
        this.authorid = authorid;
        this.authorname = authorname;
    }
    
    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return authorid + "-" + authorname;
    }
    
}
