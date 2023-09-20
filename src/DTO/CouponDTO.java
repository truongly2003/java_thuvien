/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hoangtuan
 */
public class CouponDTO {
    private int coupon_id;
    private int superlier_id;
    private int staff_id;
    private String date_add;
    public CouponDTO(){
        
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public int getSuperlier_id() {
        return superlier_id;
    }

    public void setSuperlier_id(int superlier_id) {
        this.superlier_id = superlier_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getDate_add() {
        return date_add;
    }

    public void setDate_add(String date_add) {
        this.date_add = date_add;
    }

    public CouponDTO(int coupon_id, int superlier_id, int staff_id, String date_add) {
        this.coupon_id = coupon_id;
        this.superlier_id = superlier_id;
        this.staff_id = staff_id;
        this.date_add = date_add;
    }

    @Override
    public String toString() {
        return "CouponDTO{" + "coupon_id=" + coupon_id + ", superlier_id=" + superlier_id + ", staff_id=" + staff_id + ", date_add=" + date_add + '}';
    }
    
}
