/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.CouponDTO;

/**
 *
 * @author hoangtuan
 */
public class CouponDAL {

    public static ArrayList<CouponDTO> getListCoupon() {
        Connection conn =null;
        try {
            String sql = "select * from phieunhap where trangthai = 1";
            conn = Data.getconnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<CouponDTO> dsl = new ArrayList<CouponDTO>();
            while (rs.next()) {
                CouponDTO tg = new CouponDTO();
                tg.setCoupon_id(rs.getInt("MaPhieuNhap"));
                tg.setSuperlier_id(rs.getInt("MaNCC"));
                tg.setStaff_id(rs.getInt("MaNV"));
                tg.setDate_add(rs.getString("NgayNhap"));
                dsl.add(tg);
            }
            return dsl;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }finally{
            Data.closeconection(conn);
        }

    }

    // @SuppressWarnings("null")
    public static int addCoupon(CouponDTO ke) {
        Connection conn =null;
        int i = -1;
        String sql = "insert into phieunhap (MaNCC,MaNV,NgayNhap,TrangThai) values(?,?,?,?)";

        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getSuperlier_id());
            pstm.setInt(2, ke.getStaff_id());
            pstm.setString(3, ke.getDate_add());
            pstm.setInt(4, 1);
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(conn);
        }

        return i;
    }

    public static int editCoupon(CouponDTO ke) {
        Connection conn =null;
        int i = -1;
        String sql = "update phieunhap set mancc = ? , manv = ?, ngaynhap = ?  where MaPhieuNhap = ?";

        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getSuperlier_id());
            pstm.setInt(2, ke.getStaff_id());
            pstm.setString(3, ke.getDate_add());
            pstm.setInt(4, ke.getCoupon_id());
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            Data.closeconection(conn);
        }

        return i;
    }

    public static int deleteCoupon(CouponDTO ke) {
        Connection conn =null;
        int i = -1;
        String sql = "delete from phieunhap where maphieunhap = ?";
        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getCoupon_id());
            // System.out.println(ke.getViTri());
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
         
        }finally{
            Data.closeconection(conn);
        }

        return i;
    }

    public static CouponDTO getCoupon(int ma) {
        Connection conn =null;
        try {
            String sql = "select * from phieunhap where MaPhieuNhap =?";
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ma);
            ResultSet rs = pstm.executeQuery();
            CouponDTO pn = new CouponDTO();
            if (rs.next()) {
                pn.setStaff_id(rs.getInt("MaNV"));
                pn.setCoupon_id(rs.getInt("MaPhieuNhap"));
                pn.setSuperlier_id(rs.getInt("MaNCC"));
                pn.setDate_add(rs.getString("NgayNhap"));

            }
            return pn;
        } catch (Exception e) {
            return null;
        }finally{
            Data.closeconection(conn);
        }
    }

}
