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

import DTO.CouponDetailDTO;

/**
 *
 * @author hoangtuan
 */
public class CouponDetailDAL {

    public static ArrayList<CouponDetailDTO> getListCouponDetail() {
        Connection conn = null;
        try {
            String sql = "select * from chitietphieunhap";
            conn = Data.getconnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<CouponDetailDTO> dsl = new ArrayList<CouponDetailDTO>();
            while (rs.next()) {
                CouponDetailDTO tg = new CouponDetailDTO();
                tg.setCouponDetail_id(rs.getInt("MaCTPN"));
                tg.setCoupon_id(rs.getInt("MaPN"));
                tg.setBook_id(rs.getInt("MaSach"));
                tg.setPrice(rs.getInt("Gia"));
                tg.setQuantity(rs.getInt("Soluong"));
                tg.setTotal(rs.getInt("ThanhTien"));
                dsl.add(tg);
            }
            return dsl;
        } catch (Exception e) {

            return null;
        } finally {
            Data.closeconection(conn);
        }

    }

    // @SuppressWarnings("null")
    public static int addCouponDetail(CouponDetailDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "insert into chitietphieunhap (MaPN,MaSach,Gia,SoLuong,ThanhTien) values(?,?,?,?,?)";

        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getCoupon_id());
            pstm.setInt(2, ke.getBook_id());
            pstm.setInt(3, ke.getPrice());
            pstm.setInt(4, ke.getQuantity());
            pstm.setInt(5, ke.getTotal());

            i = pstm.executeUpdate();
            if (i > 0) {
                String sql2 = "update sach set soluong  = ? where masach = ?";
                PreparedStatement stm2 = conn.prepareStatement(sql2);
                stm2.setInt(1, BookDAL.getQuantityBook(ke.getBook_id()) + ke.getQuantity());
                stm2.setInt(2, ke.getBook_id());
                stm2.executeUpdate();
                System.out.println("Cập nhật số lượng sách sau khi nhập thành công");
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            // dreturn null;
        } finally {
            Data.closeconection(conn);
        }

        return i;
    }

    public static int editCouponDetail(CouponDetailDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "update chitietphieunhap set MaPN = ? , MaSach = ?, Gia = ?  ,SoLuong = ? , ThanhTien=?  where MaCTPN = ?";

        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getCoupon_id());
            pstm.setInt(2, ke.getBook_id());
            pstm.setInt(3, ke.getPrice());
            pstm.setInt(4, ke.getQuantity());
            pstm.setInt(5, ke.getTotal());
            pstm.setInt(6, ke.getCouponDetail_id());
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            // dreturn null;
        } finally {
            Data.closeconection(conn);
        }

        return i;
    }

    public static int deleteCouponDetail(CouponDetailDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "delete from chitietphieunhap where MaCTPN = ?";

        try {

            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getCouponDetail_id());
            // System.out.println(ke.getViTri());
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            // dreturn null;
        } finally {
            Data.closeconection(conn);
        }

        return i;
    }

    public static ArrayList<CouponDetailDTO> getStatisticalCoupon() {
        Connection conn =null;
        ArrayList<CouponDetailDTO> list = new ArrayList<CouponDetailDTO>();
        try {
            String sql = "SELECT chitietphieunhap.*, phieunhap.NgayNhap, sach.TenSach FROM chitietphieunhap INNER JOIN phieunhap ON chitietphieunhap.MaPN = phieunhap.MaPhieuNhap INNER JOIN sach ON chitietphieunhap.MaSach = sach.MaSach";
            conn = Data.getconnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                CouponDetailDTO ct = new CouponDetailDTO();
                ct.setCouponDetail_id(rs.getInt("MaCTPN"));
                ct.setCoupon_id(rs.getInt("MaPN"));
                ct.setBook_id(rs.getInt("MaSach"));
                ct.setPrice(rs.getInt("Gia"));
                ct.setQuantity(rs.getInt("Soluong"));
                ct.setTotal(rs.getInt("ThanhTien"));
                ct.setDate_add(rs.getString("Ngaynhap"));
                ct.setBook_name(rs.getString("Tensach"));
                list.add(ct);
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Data.closeconection(conn);
        }
        return null;
    }

    public static ArrayList<CouponDetailDTO> getStatisticalByYear(int year) {
        Connection conn =null;
        ArrayList<CouponDetailDTO> list = new ArrayList<CouponDetailDTO>();
        try {
            String sql = "SELECT chitietphieunhap.*, phieunhap.NgayNhap, sach.TenSach FROM chitietphieunhap INNER JOIN phieunhap ON chitietphieunhap.MaPN = phieunhap.MaPhieuNhap INNER JOIN sach ON chitietphieunhap.MaSach = sach.MaSach WHERE phieunhap.NgayNhap BETWEEN '"
                    + year + "-01-01' AND '" + year + "-12-31'";
            conn = Data.getconnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                CouponDetailDTO ct = new CouponDetailDTO();
                ct.setCouponDetail_id(rs.getInt("MaCTPN"));
                ct.setCoupon_id(rs.getInt("MaPN"));
                ct.setBook_id(rs.getInt("MaSach"));
                ct.setPrice(rs.getInt("Gia"));
                ct.setQuantity(rs.getInt("Soluong"));
                ct.setTotal(rs.getInt("ThanhTien"));
                ct.setBook_name(rs.getString("Tensach"));
                ct.setDate_add(rs.getString("Ngaynhap"));
                list.add(ct);
            }
            
            return list;
        } catch (Exception e) {
            return null;
        }finally {
            Data.closeconection(conn);
        }

    }

    public static ArrayList<CouponDetailDTO> getStatisticalByDay(String date1, String date2) {
        Connection conn =null;
        ArrayList<CouponDetailDTO> list = new ArrayList<CouponDetailDTO>();
        try {
            String sql = "SELECT chitietphieunhap.*, phieunhap.NgayNhap, sach.TenSach FROM chitietphieunhap INNER JOIN phieunhap ON chitietphieunhap.MaPN = phieunhap.MaPhieuNhap INNER JOIN sach ON chitietphieunhap.MaSach = sach.MaSach WHERE phieunhap.NgayNhap BETWEEN '"
                    + date1 + "' AND '" + date2 + "'";
            conn = Data.getconnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                CouponDetailDTO ct = new CouponDetailDTO();
                ct.setCouponDetail_id(rs.getInt("MaCTPN"));
                ct.setCoupon_id(rs.getInt("MaPN"));
                ct.setBook_id(rs.getInt("MaSach"));
                ct.setPrice(rs.getInt("Gia"));
                ct.setQuantity(rs.getInt("Soluong"));
                ct.setTotal(rs.getInt("ThanhTien"));
                ct.setBook_name(rs.getString("Tensach"));
                ct.setDate_add(rs.getString("Ngaynhap"));
                list.add(ct);
            }
            return list;
        } catch (Exception e) {
            return null;
        }finally {
            Data.closeconection(conn);
        }

    }
}
