/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.SupplierDAL;
import DTO.SupplierDTO;

/**
 *
 * @author hoangtuan
 */
public class SupplierBUS {

    private SupplierDAL supplierDAL = new SupplierDAL();
    private ArrayList<SupplierDTO> listsupp = new ArrayList<SupplierDTO>();

    public ArrayList<SupplierDTO> getListSuppler() {
        return SupplierDAL.getListSupplier();
    }

    public int addSupplier(SupplierDTO ncc) {
        if (ncc.getSupplier_name().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống tên nhà cung cấp");
            return -1;
        }
        for (SupplierDTO nccc : getListSuppler()) {
            if (nccc.getSupplier_name().equalsIgnoreCase(ncc.getSupplier_name())) {
                JOptionPane.showMessageDialog(null, "Tên nhà cung cấp đã trùng");
                return -1;
            }
        }
        if (supplierDAL.addSupplier(ncc) > 0) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;
        }
        JOptionPane.showMessageDialog(null, "Thêm thất bại");
        return -1;
    }

    public int editSupplier(SupplierDTO ncc) {
        if (ncc.getSupplier_name().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống tên nhà cung cấp");
            return -1;
        }
        for (SupplierDTO nccc : getListSuppler()) {
            if (nccc.getSupplier_name().equalsIgnoreCase(ncc.getSupplier_name())) {
                JOptionPane.showMessageDialog(null, "Tên nhà cung cấp đã trùng");
                return -1;
            }
        }
        if (supplierDAL.editSupplier(ncc) > 0) {
            JOptionPane.showMessageDialog(null, "Sửa  thành công");
            return 1;
        }
        JOptionPane.showMessageDialog(null, "Sửa thất bại");
        return -1;
    }

    public int deleteSupplier(SupplierDTO ncc) {
        if (supplierDAL.deleteSupplier(ncc) > -1) {
            JOptionPane.showMessageDialog(null, "Xoá thành công");
            return 1;
        }
        JOptionPane.showMessageDialog(null, "Xoá thất bại");
        return -1;
    }

    public static SupplierBUS gI() {
        return new SupplierBUS();
    }
}
