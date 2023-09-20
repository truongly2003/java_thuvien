/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import DTO.BorrowDetailDTO;

/**
 *
 * @author hoangtuan
 */
public class BorrowDetailDAL {

    public static ArrayList<BorrowDetailDTO> getListBorrow() {
        Connection conn = null;
        try {
            String sql = "select * from chitietphieumuon where trangthai =1 ";
            conn = Data.getconnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<BorrowDetailDTO> dsl = new ArrayList<BorrowDetailDTO>();
            while (rs.next()) {
                BorrowDetailDTO ctpm = new BorrowDetailDTO();
                ctpm.setBorrowDetail_id(rs.getInt("MaCTPM"));
                ctpm.setBorrow_id(rs.getInt("MaPM"));
                ctpm.setBook_id(rs.getInt("MaSach"));
                String ngaytra = rs.getString("NgayTra");
                ctpm.setPay_day(ngaytra);
                String ghichu = null;

                if (CompareTwoDatesTest(ngaytra) == -1) {
                    ghichu = "Đã Hết Hạn";
                } else if (CompareTwoDatesTest(ngaytra) == 1) {
                    ghichu = "Chưa hết hạn";
                } else {
                    ghichu = "Hôm nay là hạn cuối";
                }

                ctpm.setNote(ghichu);
                dsl.add(ctpm);
            }

            return dsl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Data.closeconection(conn);
        }
    }

    public static int addBorrowDetail(BorrowDetailDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "insert into chitietphieumuon (MaPM,MaSach,NgayTra,GhiChu,TrangThai) values(?,?,?,?,?)";
        try {

            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getBorrow_id());
            pstm.setInt(2, ke.getBook_id());
            pstm.setString(3, ke.getPay_day());
            pstm.setString(4, ke.getNote());
            pstm.setInt(5, 1);
            i = pstm.executeUpdate();
            if (i > 0) {
                String sql1 = "update sach set soluong = ? where masach = ?";
                PreparedStatement pstm2 = conn.prepareStatement(sql1);
                pstm2.setInt(1, BookDAL.getQuantityBook(ke.getBook_id()) - 1);
                pstm2.setInt(2, ke.getBook_id());
                pstm2.executeUpdate();
                System.out.println("Đã Cập Nhật Số Lượng Sách");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Data.closeconection(conn);
        }

        return i;
    }

    public static int editBorrowDetail(BorrowDetailDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "update chitietphieumuon set MaPM = ? , MaSach = ?, NgayTra =? , GhiChu =?  where mactpm = ?";

        try {

            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getBorrow_id());
            pstm.setInt(2, ke.getBook_id());
            pstm.setString(3, ke.getPay_day());
            pstm.setString(4, ke.getNote());
            pstm.setInt(5, ke.getBorrowDetail_id());
            i = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Data.closeconection(conn);
        }

        return i;
    }

    public static int deleteBorrowDetail(BorrowDetailDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "delete from chitietphieumuon where mactpm = ?";
        try {

            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getBorrowDetail_id());
            // System.out.println(ke.getViTri());
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Data.closeconection(conn);
        }
        return i;
    }

    public static int CompareTwoDatesTest(String date) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        try {
            d1 = sdformat.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        Date d2 = null;
        try {
            d2 = sdformat.parse(dtf.format(now));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        if (d1.compareTo(d2) > 0) {
            return 1;
        } else if (d1.compareTo(d2) < 0) {
            return -1;
        } else if (d1.compareTo(d2) == 0) {
            return 2;
        }
        return 0;

    }

    public static int getQuantityBookBorrow() {
        Connection conn = null;
        try {
            int soluong = 0;
            String sql = "select masach from chitietphieumuon where trangthai =1";
            conn = Data.getconnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                soluong++;
            }
            return soluong;
        } catch (Exception e) {
            return -1;
        } finally {
            Data.closeconection(conn);
        }
    }

    public static ArrayList<BorrowDetailDTO> statisticalBorrow() {
        Connection conn = null;
        try {
            String sql = "SELECT chitietphieumuon.* , phieumuon.NgayMuon FROM chitietphieumuon INNER JOIN phieumuon ON phieumuon.MaPM= chitietphieumuon.MaPM";
            conn = Data.getconnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<BorrowDetailDTO> dsl = new ArrayList<BorrowDetailDTO>();
            while (rs.next()) {
                BorrowDetailDTO ctpm = new BorrowDetailDTO();
                ctpm.setBorrowDetail_id(rs.getInt("borrowDetail_id"));
                ctpm.setBorrow_id(rs.getInt("borrow_id"));
                ctpm.setBook_id(rs.getInt("book_id"));
                String ngaytra = rs.getString("pay_day");
                ctpm.setPay_day(ngaytra);
                String ghichu = null;
                if (CompareTwoDatesTest(ngaytra) == -1) {
                    ghichu = "Đã Hết Hạn";
                } else if (CompareTwoDatesTest(ngaytra) == 1) {
                    ghichu = "Chưa hết hạn";
                } else {
                    ghichu = "Hôm nay là hạn cuối";
                }
                ctpm.setNote(ghichu);
                ctpm.setBorrow_date(rs.getString("borrow_date"));
                dsl.add(ctpm);
            }
            return dsl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Data.closeconection(conn);
        }

    }

    public static BorrowDetailDTO getBookId(int id) {
        Connection conn = null;
        String sql = "select MaSach from chitietphieumuon where mactpm = ?";
        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            BorrowDetailDTO ct = new BorrowDetailDTO();
            if (rs.next()) {
                ct.setBook_id(rs.getInt(1));
            }
            conn.close();
            return ct;
        } catch (Exception e) {
            return null;
        } finally {
            Data.closeconection(conn);
        }
    }
}
