package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.ReaderDTO;
import DTO.BookCategoryDTO;

public class ReaderDAL {

    public static ArrayList<ReaderDTO> getListReader() {
        try {
            String sql = "SELECT * FROM docgia WHERE trangthai =1";
            Connection conn = Data.getconnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<ReaderDTO> dsl = new ArrayList<>();
            while (rs.next()) {
                // System.out.println("Db connect");
                ReaderDTO rd = new ReaderDTO();
                rd.setReader_id(rs.getInt(1));
                rd.setAddress(rs.getString(4));
                rd.setReaderName(rs.getString(2));
                rd.setGender(rs.getString(3));
                rd.setPhoneNumber(rs.getString(5));

                dsl.add(rd);

            }

            return dsl;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    // @SuppressWarnings("null")
    public static int addReader(ReaderDTO rd) {
        int i = -1;
        String sql = "insert into docgia (tendocgia,gioitinh,diachi,sdt,trangthai) values(?,?,?,?,?)";

        try {

            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, rd.getReaderName());
            pstm.setString(2, rd.getGender());

            pstm.setString(3, rd.getAddress());
            pstm.setString(4, rd.getPhoneNumber());
            pstm.setInt(5, 1);
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            // dreturn null;
        }

        return i;
    }

    public static int editReader(ReaderDTO rd) {
        int i = -1;
        String sql = "update docgia set tendocgia = ?,diachi =? ,gioitinh = ?,sdt = ? where madocgia = ?";
        try {
            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, rd.getReaderName());

            pstm.setString(2, rd.getAddress());
            pstm.setString(3, rd.getGender());
            pstm.setString(4, rd.getPhoneNumber());
            pstm.setInt(5, rd.getReader_id());
            i = pstm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    public static int remoteReader(ReaderDTO rd) {
        int i = -1;
        //	String sql = "delete from docgia where madocgia = ?";
        String sql = "update docgia set trangthai = 0 where madocgia = ?";
        try {

            Connection conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, rd.getReader_id());
            // System.out.println(ke.getViTri());
            i = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            // dreturn null;
        }

        return i;
    }

    public ReaderDTO searchReader(int id) {
        String sql = "select * from docgia where madocgia = ? and trangthai = 1 ";
        ReaderDTO rd = new ReaderDTO();
        try {
            Connection conn = Data.getconnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rd.setReader_id(rs.getInt(1));
                rd.setAddress(rs.getString(4));
                rd.setReaderName(rs.getString(2));
                rd.setGender(rs.getString(3));
                rd.setPhoneNumber(rs.getString(5));
            }
            return rd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
