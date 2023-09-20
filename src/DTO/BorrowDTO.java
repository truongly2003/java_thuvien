/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hoangtuan
 */
public class BorrowDTO {
    private int borrow_id;
    private int staff_id;
    private int reader_id;
    private String borrow_date;
    private String status;

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BorrowDTO(int borrow_id, int staff_id, int reader_id, String borrow_date, String status) {
        this.borrow_id = borrow_id;
        this.staff_id = staff_id;
        this.reader_id = reader_id;
        this.borrow_date = borrow_date;
        this.status = status;
    }
    public BorrowDTO(){
    }

    @Override
    public String toString() {
        return "BorrowDTO{" + "borrow_id=" + borrow_id + ", staff_id=" + staff_id + ", reader_id=" + reader_id + ", borrow_date=" + borrow_date + ", status=" + status + '}';
    }
    
}
