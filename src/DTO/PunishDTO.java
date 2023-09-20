/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hoangtuan
 */
public class PunishDTO {
    private int punish_id;
    private int borrow_id;
    private String reason;
    private String fine;
    public PunishDTO(){
        
    }
    public PunishDTO(int punish_id, int borrow_id, String reason, String fine) {
        this.punish_id = punish_id;
        this.borrow_id = borrow_id;
        this.reason = reason;
        this.fine = fine;
    }

    public int getPunish_id() {
        return punish_id;
    }

    public void setPunish_id(int punish_id) {
        this.punish_id = punish_id;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "PunishDTO{" + "punish_id=" + punish_id + ", borrow_id=" + borrow_id + ", reason=" + reason + ", fine=" + fine + '}';
    }
}
