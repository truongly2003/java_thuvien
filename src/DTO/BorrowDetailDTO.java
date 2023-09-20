/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hoangtuan
 */
public class BorrowDetailDTO {
    private int borrowDetail_id;
    private int borrow_id;
    private int book_id;
    private String borrow_date;
    private String pay_day;
    private String note;
    public BorrowDetailDTO(){
    }
    public BorrowDetailDTO(int borrowDetail_id, int borrow_id, int book_id, String borrow_date, String pay_day, String note) {
        this.borrowDetail_id = borrowDetail_id;
        this.borrow_id = borrow_id;
        this.book_id = book_id;
        this.borrow_date = borrow_date;
        this.pay_day = pay_day;
        this.note = note;
    }

    public BorrowDetailDTO(int borrowDetail_id, int borrow_id, int book_id, String pay_day, String note) {
        this.borrowDetail_id = borrowDetail_id;
        this.borrow_id = borrow_id;
        this.book_id = book_id;
        this.pay_day = pay_day;
        this.note = note;
    }
    
    public int getBorrowDetail_id() {
        return borrowDetail_id;
    }

    public void setBorrowDetail_id(int borrowDetail_id) {
        this.borrowDetail_id = borrowDetail_id;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getPay_day() {
        return pay_day;
    }

    public void setPay_day(String pay_day) {
        this.pay_day = pay_day;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "BorrowDetailDTO{" + "borrowDetail_id=" + borrowDetail_id + ", borrow_id=" + borrow_id + ", book_id=" + book_id + ", borrow_date=" + borrow_date + ", pay_day=" + pay_day + ", note=" + note + '}';
    }
    
    
}
