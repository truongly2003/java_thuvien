/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hoangtuan
 */
public class SupplierDTO {
    private int supplier_id;
    private String supplier_name;
    public SupplierDTO(){
    }

    public SupplierDTO(int supplier_id, String supplier_name) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" + "supplier_id=" + supplier_id + ", supplier_name=" + supplier_name + '}';
    }
    
}
