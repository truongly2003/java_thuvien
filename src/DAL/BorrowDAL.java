/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.BorrowDetailDTO;
import DTO.BorrowDTO;

/**
 *
 * @author hoangtuan
 */
public class BorrowDAL {

    public static ArrayList<BorrowDTO> getListBorrow() {
        Connection conn = null;
        try {
            String sql = "select * from phieumuon where trangthai = 1";
            conn = Data.getconnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<BorrowDTO> dsl = new ArrayList<BorrowDTO>();
            while (rs.next()) {
                BorrowDTO pm = new BorrowDTO();
                pm.setBorrow_id(rs.getInt(1));
                pm.setStaff_id(rs.getInt(2));
                pm.setReader_id(rs.getInt(3));
                pm.setBorrow_date(rs.getString(4));
                pm.setStatus(rs.getString(5));
                dsl.add(pm);
            }
            return dsl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Data.closeconection(conn);
        }
    }

    public static int addBorrow(BorrowDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "insert into phieumuon(MaNV,MaDocGia,NgayMuon,TinhTrang,TrangThai) values(?,?,?,?,?)";
        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getStaff_id());
            pstm.setInt(2, ke.getReader_id());
            pstm.setString(3, ke.getBorrow_date());
            pstm.setString(4, ke.getStatus());
            pstm.setInt(5, 1);
            i = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Data.closeconection(conn);
        }
        return i;
    }

    public static ArrayList<BorrowDetailDTO> listBorrowDetail(int ke) {
        Connection conn = null;
        try {
            conn = Data.getconnection();
            String sql2 = "SELECT * FROM `chitietphieumuon` WHERE mapm = ?";
            ArrayList<BorrowDetailDTO> list = new ArrayList<BorrowDetailDTO>();
            PreparedStatement pstm2 = conn.prepareStatement(sql2);
            pstm2.setInt(1, ke);
            ResultSet rs = pstm2.executeQuery();

            while (rs.next()) {
                BorrowDetailDTO pm = new BorrowDetailDTO();
                pm.setBorrowDetail_id(rs.getInt(1));
                pm.setBorrow_id(rs.getInt(2));
                pm.setBook_id(rs.getInt(3));
                list.add(pm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Data.closeconection(conn);
        }
    }

    public static int editBorrow(BorrowDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "update phieumuon set manv = ? , MaDocGia = ?, NgayMuon =? , TinhTrang =?  where mapm = ?";
        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getStaff_id());
            pstm.setInt(2, ke.getReader_id());
            pstm.setString(3, ke.getBorrow_date());
            pstm.setString(4, ke.getStatus());
            pstm.setInt(5, ke.getBorrow_id());
            if (ke.getStatus().contains("Đã Trả")) {
                ArrayList<BorrowDetailDTO> list = listBorrowDetail(ke.getBorrow_id());
                if (list != null) {
                    for (BorrowDetailDTO ctpm : list) {
                        String sql2 = "update sach set soluong = ? where masach = ?";
                        PreparedStatement stm2 = conn.prepareStatement(sql2);
                        stm2.setInt(1, BookDAL.getQuantityBook(ctpm.getBook_id()) + 1);
                        stm2.setInt(2, ctpm.getBook_id());
                        stm2.executeUpdate();
                        System.out.println("Phiếu mượn DAL : Update số lượng thành công");
                    }
                }
            }
            i = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            // dreturn null;
        } finally {
            Data.closeconection(conn);
        }

        return i;
    }

    public static int deleteBorrow(BorrowDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "delete from phieumuon where mapm = ?";
//        String sql = "update phieumuon set TrangThai = 0 where mapm = ?";
        try {

            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getBorrow_id());
            // System.out.println(ke.getViTri());
            i = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Data.closeconection(conn);
        }

        return i;
    }

    public BorrowDTO searchBorrow(int id) {
        BorrowDTO br = null;
        Connection conn = null;
        try {
            String sql = "select * from phieumuon where mapm = ? and trangthai = 1";
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                br = new BorrowDTO();
                br.setBorrow_id(rs.getInt(1));
                br.setStaff_id(rs.getInt(2));
                br.setReader_id(rs.getInt(3));
                br.setBorrow_date(rs.getString(4));
                br.setStatus(rs.getString(5));
            }

            return br;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Data.closeconection(conn);
        }
    }
}
