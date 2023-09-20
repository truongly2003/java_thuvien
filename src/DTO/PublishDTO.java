package DTO;
public class PublishDTO {
    private int publishid;
    private String publishname;
    private String address;
    private String phone;

    public PublishDTO(int publishid, String publishname, String address, String phone) {
        this.publishid = publishid;
        this.publishname = publishname;
        this.address = address;
        this.phone = phone;
    }

    public PublishDTO() {
    }

    public int getPublishid() {
        return publishid;
    }

    public void setPublishid(int publishid) {
        this.publishid = publishid;
    }

    public String getPublishname() {
        return publishname;
    }

    public void setPublishname(String publishname) {
        this.publishname = publishname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return publishid + "-" + publishname;
    }
}
