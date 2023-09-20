/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAL.BorrowDAL;

import DTO.BorrowDTO;
import GUI.BorrowGUI;

/**
 *
 * @author hoangtuan
 */
public class BorrowBUS {
    BorrowDAL pmdal = new BorrowDAL();
    private ArrayList<BorrowDTO> listpm = new ArrayList<BorrowDTO>();

    public ArrayList<BorrowDTO> getListBorrow() {

        return listpm = pmdal.getListBorrow();
    }

    public void showmess(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public int addBorrow(BorrowDTO pm) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            if (pm.getStaff_id() < 0) {
                showmess("Mã nhân viên sai");
                return -1;
            }
            if (sdf.parse(pm.getBorrow_date()).after(date)) {
                showmess("Ngày mượn sai");
                return -1;
            }
            if(pm.getBorrow_date() == null){
                showmess("Không được để ngày mượn trống");
                return -1;
            }
            if (BorrowDAL.addBorrow(pm) > 0) {
                showmess("Đã thêm phiếu mượn thành công");
                return 1;
            }
            showmess("Đã thêm phiếu mượn thất bại");
            return -1;

        } catch (Exception e) {
            return -1;
        }
    }

    public int editBorrow(BorrowDTO pm) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            if (pm.getStaff_id() < 0) {
                showmess("Mã nhân viên sai");
                return -1;
            }
            if (sdf.parse(pm.getBorrow_date()).after(date)) {
                showmess("Ngày mượn sai");
                return -1;
            }
            if (BorrowDAL.editBorrow(pm) > 0) {
                showmess("Đã sửa phiếu mượnt thành công");
                return 1;
            }
            showmess("Đã sửa phiếu mượnt thất bại");
            return -1;

        } catch (Exception e) {
            return -1;
        }
    }

    public int deleteBorrow(BorrowDTO pm) {
        if (BorrowDAL.deleteBorrow(pm) > 0) {
            showmess("Đã xoá phiếu mượn thành công");
            return 1;
        }
        showmess("Đã xoa phiếu mượnt thất bại");
        return -1;
    }

    public BorrowDTO searchBorrow(int id) {
        if (id > 0) {
            return pmdal.searchBorrow(id);
        }
        return null;
    }

//    public static BorrowBUS iBus = null;
//
//    public static BorrowBUS gI() {
//        if (iBus == null) {
//            iBus = new BorrowBUS();
//        }
//        return iBus;
//    }
}
