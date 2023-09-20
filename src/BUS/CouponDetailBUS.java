/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.CouponDetailDAL;
import DTO.CouponDetailDTO;

/**
 *
 * @author hoangtuan
 */
public class CouponDetailBUS {
    private ArrayList<CouponDetailDTO> listpm = new ArrayList<CouponDetailDTO>();

    public ArrayList<CouponDetailDTO> getListCouponDetail() {

        return listpm = CouponDetailDAL.getListCouponDetail();
    }

    public ArrayList<CouponDetailDTO> getStatisticalByYear(int year) {
        // thống kê theo năm

        return CouponDetailDAL.getStatisticalByYear(year);

    }
    

    public ArrayList<CouponDetailDTO> getStatisticalByDay(String date1, String date2) {
        // thống kê theo ngày

        return CouponDetailDAL.getStatisticalByDay(date1, date2);

    }

    public ArrayList<CouponDetailDTO> getStatisticalCoupon() {

        return CouponDetailDAL.getStatisticalCoupon();
    }

    public int addCouponDetail(CouponDetailDTO cp) {
        if (CouponDetailDAL.addCouponDetail(cp) > 0) {
            JOptionPane.showMessageDialog(null, "Đã thêm chi tiết thành công");
            return 1;
        }
        JOptionPane.showMessageDialog(null, "Đã thêm chi tiết thất bại");

        return -1;
    }

    public int editCouponDetail(CouponDetailDTO cp) {
        if (CouponDetailDAL.editCouponDetail(cp) > 0) {
            JOptionPane.showMessageDialog(null, "Đã sửa chi tiết thành công");
            return 1;
        }
        JOptionPane.showMessageDialog(null, "Đã sửa chi tiết thất bại");

        return -1;
    }

    public int deleteCouponDetail(CouponDetailDTO cp) {
        if (CouponDetailDAL.deleteCouponDetail(cp) > 0) {
            JOptionPane.showMessageDialog(null, "Đã xoá chi tiết thành công");
            return 1;
        }
        JOptionPane.showMessageDialog(null, "Đã xoá chi tiết thất bại");

        return -1;
    }

    public static CouponDetailBUS iBus = null;

//    public Object getPhieuNhap(int mapn) {
//        for (CouponDetailDTO ctpn : listpm) {
//            if (ctpn.getCouponDetail_id()== mapn) {
//                return mapn;
//            }
//
//        }
//        return null;
//    }

    public static CouponDetailBUS gI() {
        if (iBus == null) {
            iBus = new CouponDetailBUS();
        }

        return iBus;
    }
}
