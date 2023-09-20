/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import DTO.StaffDTO;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author PC
 */
public class StaffDAL {
    public static int addStaff(StaffDTO nv){
        int i = -1;
        String sql = "INSERT INTO NHANVIEN (tennv,namsinh,gioitinh,diachi,sdt,trangthai) values(?,?,?,?,?,?)";
        try {
            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nv.getStaff_name());
            pstm.setString(2, nv.getBirthYear());
            pstm.setString(3, nv.getGender());
            pstm.setString(4, nv.getAddress());
            pstm.setString(5, nv.getPhoneNumber());
            pstm.setInt(6, 1);
            i = pstm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    public static int editStaff(StaffDTO nv){
        int i = -1;
        String sql = "UPDATE nhanvien SET tennv = ?, namsinh = ?, gioitinh = ?, diachi = ?, sdt = ?  WHERE manv = ?";
        
        try {
            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nv.getStaff_name());
            pstm.setString(2,nv.getBirthYear());
            pstm.setString(3, nv.getGender());
            pstm.setString(4, nv.getAddress());
            pstm.setString(5,nv.getPhoneNumber());
            pstm.setInt(6, nv.getStaff_id());
            i = pstm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    public static int remoteStaff(StaffDTO nv){
        int i = -1;
//        String sql = "UPDATE nhanvien SET trangthai = 0 where manv = ?";
        String sql = "delete from nhanvien where manv = ?";
        try {
            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, nv.getStaff_id());
            i = pstm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    public static ArrayList<StaffDTO> getListStaff(){
        ArrayList<StaffDTO> ds1 = new ArrayList<>();
        try {
            Connection conn = Data.getconnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nhanvien WHERE trangthai = 1");
            
            
            while(rs.next()){
                StaffDTO nv = new StaffDTO();
                nv.setStaff_id(rs.getInt(1));
                nv.setStaff_name(rs.getString(2));
                nv.setBirthYear(rs.getString(3));
                nv.setGender(rs.getString(4));
                nv.setAddress(rs.getString(5));
                nv.setPhoneNumber(rs.getString(6));
                nv.setWage(0);
                ds1.add(nv);
            }
            
        } catch (Exception e) {
            return null;
        }
        return ds1;
    }
    public static StaffDTO getSatff(int id){
        try {
            String sql = "SELECT tennv FROM nhanvien WHERE manv = ?";
            StaffDTO nv = new StaffDTO();
            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                nv.setStaff_name(rs.getString("tennv"));
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public StaffDTO searchStaff(int id) {
        StaffDTO nv = null;
        try {

            String sql = "select * from nhanvien where manv = ? and trangthai = 1";
            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                nv = new StaffDTO();
                nv.setStaff_id(rs.getInt(1));
                nv.setStaff_name(rs.getString(2));
                nv.setBirthYear(rs.getString(3));
                nv.setGender(rs.getString(4));
                nv.setAddress(rs.getString(5));
                nv.setPhoneNumber(rs.getString(6));
            }
            conn.close();
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
         
        }
        return null;
    }
}
