/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hoangtuan
 */
public class CouponDetailDTO {
    private int couponDetail_id;
    private int coupon_id;
    private int book_id;
    private int price;
    private int quantity;
    private int total;
    private String book_name;
    private String date_add;
    public CouponDetailDTO(){
    }

    public CouponDetailDTO(int couponDetail_id, int coupon_id, int book_id, int price, int quantity, int total  ) {
        this.couponDetail_id = couponDetail_id;
        this.coupon_id = coupon_id;
        this.book_id = book_id;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public int getCouponDetail_id() {
        return couponDetail_id;
    }

    public void setCouponDetail_id(int couponDetail_id) {
        this.couponDetail_id = couponDetail_id;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getDate_add() {
        return date_add;
    }

    public void setDate_add(String date_add) {
        this.date_add = date_add;
    }
    
    @Override
    public String toString() {
        return "CouponDetailDTO{" + "couponDetail_id=" + couponDetail_id + ", coupon_id=" + coupon_id + ", book_id=" + book_id + ", price=" + price + ", quantity=" + quantity + ", total=" + total + ", book_name=" + book_name + '}';
    }
    
}
