/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author PC
 */
import DAL.StaffDAL;
import DTO.StaffDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StaffBUS {

    private StaffDAL staffDAL = new StaffDAL();
    private ArrayList<StaffDTO> listnv = new ArrayList<>();

    public ArrayList<StaffDTO> getListStaff() {
        return StaffDAL.getListStaff();
    }

    public void showMess(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public int addStaff(StaffDTO nv) {
        if (nv.getStaff_name().isEmpty()) {
            JOptionPane.showMessageDialog(null, "không được để trống tên nhân viên");
            return -1;
        }
        if (!nv.getStaff_name().matches("[\\p{L}\\s]+") || nv.getStaff_name().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "tên nhân viên không hợp lệ!!");
            return -1;
        }
        if (nv.getGender() == null || nv.getGender().isEmpty()) {
            showMess("bạn chưa chọn giới tính");
            return -1;
        }
        if (nv.getGender().isEmpty()) {
            showMess("không dược để trống giới tính ");
            return -1;
        }
        if (nv.getAddress().isEmpty()) {
            showMess("không được để trống địa chỉ");
            return -1;
        }

        if (nv.getBirthYear().isEmpty()) {
            showMess("không được để trống năm sinh");
            return -1;
        }
        if (nv.getPhoneNumber().isEmpty()) {
            showMess("không được để trống số điện thoại");
            return -1;
        }
        if (nv.getPhoneNumber().length() != 10 || !nv.getPhoneNumber().matches("\\d+")) {
            showMess("Số điện thoại không hợp lệ");
            return -1;
        }
        if (StaffDAL.addStaff(nv) > 0) {
            showMess("đã thêm nhân viên thành công");
            return 1;
        }
//        if(!nv.getGender().equals("Nam") || !nv.getGender().equals("Nữ")){
//            showMess("nhập giới tính sai");
//            return -1;
//        }
        showMess("thêm nhân viên thất bại");
        return -1;
    }

    public int editStaff(StaffDTO nv) {
        if (nv.getStaff_name().isEmpty()) {
            JOptionPane.showMessageDialog(null, "không được để trống tên nhân viên");
            return -1;
        }
        if (nv.getAddress().isEmpty()) {
            showMess("không được để trống địa chỉ");
            return -1;
        }
        if (nv.getGender().isEmpty()) {
            showMess("không được để trống giới tính");
            return -1;
        }
        if (nv.getBirthYear().isEmpty()) {
            showMess("không được để trống năm sinh");
            return -1;
        }
        if (nv.getPhoneNumber().isEmpty()) {
            showMess("không được để trống số điện thoại");
            return -1;
        }
        if (StaffDAL.editStaff(nv) > 0) {
            showMess("đã sửa nhân viên thành công");
            return 1;
        }
        showMess("sửa nhân viên thất bại");
        return -1;
    }

    public int remoteStaff(StaffDTO nv) {
        if (StaffDAL.remoteStaff(nv) > 0) {
            showMess("đã xóa nhân viên thành công");
            return 1;
        }
        showMess("xóa nhân viên thất bại");
        return -1;
    }

    public StaffDTO searchStaff(int id) {
        if (id > 0) {
            return staffDAL.searchStaff(id);
        }
        return null;
    }

    public static StaffBUS gI() {
        return new StaffBUS();
    }
}
