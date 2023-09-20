/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.ReaderDAL;
import DTO.ReaderDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ReaderBUS {
    ReaderDAL rd = new ReaderDAL();

    public static ReaderBUS rd1 = null;
    private ArrayList<ReaderDTO> listrd = new ArrayList<>();

    public static ReaderBUS gI() {
        return new ReaderBUS();
    }
    public void showmess(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public ArrayList<ReaderDTO> getListReader() {

        return rd.getListReader();
    }

    public int AddReader(ReaderDTO rd) {
        
        boolean isSelectedGender = true;
        if (rd.getReaderName().isEmpty()) {
            showmess("Không được bỏ trống tên đọc giả");
            return -1;
        }
        if (!rd.getReaderName().matches("[\\p{L}\\s]+") || rd.getReaderName().trim().isEmpty()) {
            showmess("nhập tên độc giả không hợp lệ");
            return -1;
        }
        if(rd.getGender() == null || rd.getGender().isEmpty()){
            showmess("bạn chưa chọn giới tính");
            return -1;
        }
        if (rd.getAddress().isEmpty()) {
            showmess("Không được bỏ trống địa chỉ");
            return -1;
        }
        if (rd.getPhoneNumber().isEmpty()) {
            showmess("Số điện thoại không được bỏ trống");
            return -1;
        }
        if (rd.getPhoneNumber().length() != 10 || !rd.getPhoneNumber().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ. Vui lòng nhập số điện thoại 10 chữ số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        if (ReaderDAL.addReader(rd) > 0) {
            showmess("Thêm độc giả thành công");
            return 1;
        }
        showmess("Thêm đọc giả thất bại");
        return -1;

    }

    public int editReader(ReaderDTO rd) {
        if (rd.getReaderName().isEmpty()) {
            showmess("Không được bỏ trống tên đọc giả");
            return -1;
        }
        if (!rd.getReaderName().matches("[\\p{L}\\s]+")) {
            showmess("nhập tên độc giả không hợp lệ");
            return -1;
        }
        if (rd.getAddress().isEmpty()) {
            showmess("Không được bỏ trống địa chỉ");
            return -1;
        }
        if (rd.getPhoneNumber().isEmpty()) {
            showmess("Số điện thoại không được bỏ trống");
            return -1;
        }
        if (rd.getPhoneNumber().length() != 10 || !rd.getPhoneNumber().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ. Vui lòng nhập số điện thoại 10 chữ số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        if (rd.getGender().isEmpty()) {
            showmess("Giới tính không được bỏ trống");
            return -1;
        }
        if (ReaderDAL.editReader(rd) > 0) {
            showmess("Sửa độc giả thành công");
            return 1;
        }
        showmess("Sửa đọc giả thất bại");
        return -1;
    }

    public int remoteReader(ReaderDTO rd) {
        if (ReaderDAL.remoteReader(rd) > 0) {
            showmess("Xoá độc giả thành công");
            return 1;
        }
        showmess("Xoá đọc giả thất bại");
        return -1;

    }

    public ReaderDTO searchReader(int id) {
        if(id >0){
           return rd.searchReader(id); 
        }
        return null;
    }
}
