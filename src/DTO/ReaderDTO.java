/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class ReaderDTO {
    private int reader_id;
    private String readerName;
    private String gender;
    private String address;
    private String phoneNumber;

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ReaderDTO(int reader_id, String readerName, String gender, String address, String phoneNumber) {
        super();
        this.reader_id = reader_id;
        this.readerName = readerName;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public ReaderDTO() {
        super();
    }

    @Override
    public String toString() {
        return reader_id + "-" +readerName;
    }
    
    
}
