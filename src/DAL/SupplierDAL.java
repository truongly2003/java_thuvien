/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.SupplierDTO;
import DTO.SupplierDTO;

/**
 *
 * @author hoangtuan
 */
public class SupplierDAL {

    public static int addSupplier(SupplierDTO loai) {
        int i = -1;
        String sql = "insert into nhacungcap (TenNCC,trangthai) values(?,?)";

        try {
            // System.out.println("Oloai");
            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, loai.getSupplier_name());
            pstm.setInt(2, 1);
            // System.out.println(loai.getViTri());
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            // dreturn null;
        }

        return i;
    }

    public static int editSupplier(SupplierDTO loai) {
        int i = -1;
        String sql = "update nhacungcap set TenNCC = ? where MaNCC = ?";

        try {

            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, loai.getSupplier_name());
            pstm.setInt(2, loai.getSupplier_id());
            // System.out.println(loai.getViTri());
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            // dreturn null;
        }

        return i;
    }

    public static int deleteSupplier(SupplierDTO loai) {
        int i = -1;
        //String sql = "delete from nhacungcap where mancc = ?";
        String sql = "update nhacungcap set trangthai = ? where MaNCC = ?";
        try {

            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setInt(2, loai.getSupplier_id());
            // System.out.println(loai.getMaloai());
            i = pstm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            // dreturn null;
        }

        return i;
    }

    public static ArrayList<SupplierDTO> getListSupplier() {
        try {
            // String sql = "select * from loaisach";
            Connection conn = Data.getconnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from nhacungcap where trangthai = 1");
            ArrayList<SupplierDTO> dsl = new ArrayList<>();
            while (rs.next()) {
                SupplierDTO ncc = new SupplierDTO();
                ncc.setSupplier_id(rs.getInt(1));
                ncc.setSupplier_name(rs.getString(2));
                System.out.println(ncc.getSupplier_name());
                System.out.println(ncc.getSupplier_id());
                dsl.add(ncc);

            }
            return dsl;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }

    public static SupplierDTO getSupplier(int id) {
        try {
            SupplierDTO ncc = new SupplierDTO();
            String sql = "select tenncc from nhacungcap where mancc = ?";
            Connection conn = Data.getconnection();

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                ncc.setSupplier_name(rs.getString("tenncc"));;
            }
            System.out.println(ncc);
            return ncc;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
}
