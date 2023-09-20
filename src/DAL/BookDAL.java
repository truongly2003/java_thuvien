package DAL;
import java.sql.*;
import DTO.BookDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class BookDAL {
    // lấy hết sách
    public static ArrayList<BookDTO> getAllBook()
    {
        ArrayList<BookDTO> list=new ArrayList<>();
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="select * from sach where trangthai=1";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                BookDTO dto=new BookDTO();
                dto.setBookid(rs.getInt("MaSach"));
                dto.setBookname(rs.getString("TenSach"));
                dto.setCategoryid(rs.getInt("MaLoai"));
                 dto.setPublishid(rs.getInt("MaNXB"));
                dto.setAuthorid(rs.getInt("MaTacGia"));
                dto.setPublishyear(rs.getInt("NamXB"));
                dto.setQuantity(rs.getInt("SoLuong"));
                 dto.setBookshelfid(rs.getInt("MaKe"));
                dto.setImage(rs.getString("HinhAnh"));
                dto.setStatus(rs.getString("TrangThai"));
                list.add(dto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }finally{
            Data.closeconection(con);
        }
        return list;
    }
    // thêm sách
    public int insertBook(BookDTO dto)
    {
        int result=-1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="insert into sach (TenSach,MaLoai,MaNXB,MaTacGia,NamXB,SoLuong,MaKe,HinhAnh,TrangThai)"
                    + " values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);     
            st.setString(1, dto.getBookname());
            st.setInt(2, dto.getCategoryid());
            st.setInt(3, dto.getPublishid());
            st.setInt(4, dto.getAuthorid());
            st.setInt(5, dto.getPublishyear());
            st.setInt(6, dto.getQuantity());
              st.setInt(7, dto.getBookshelfid());
            st.setString(8, dto.getImage());
            st.setInt(9,1);
            result=st.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
          Data.closeconection(con);
        }
       
        return result;
    }
    // tìm kiếm sách theo mã sách 
    public BookDTO searchBook(int bookId){
        Connection con=null;
         BookDTO dto=null;
        try {
            con=Data.getconnection();
            String sql="select * from sach where MaSach=?  and TrangThai=1";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, bookId);
            ResultSet rs=st.executeQuery();
          
            while(rs.next())
            {
                dto=new BookDTO();
                dto.setBookid(rs.getInt("MaSach"));
                dto.setBookname(rs.getString("TenSach"));
                dto.setCategoryid(rs.getInt("MaLoai"));
                dto.setAuthorid(rs.getInt("MaTacGia"));
                dto.setPublishid(rs.getInt("MaNXB"));
                dto.setPublishyear(rs.getInt("NamXB"));
                dto.setQuantity(rs.getInt("SoLuong"));
                dto.setImage(rs.getString("HinhAnh"));
                dto.setBookshelfid(rs.getInt("MaKe"));
                dto.setStatus(rs.getString("TrangThai"));
                
            }
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
           
        }finally{
            Data.closeconection(con);
        }
        return null;
       
    }
    // sửa 
    public int updateBook(BookDTO dto)
    {
        int result=-1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="update sach set TenSach = ? , MaLoai = ?, MaNXB = ?, MaTacGia =? , NamXB =? ,SoLuong  =? ,MaKe  =? , HinhAnh =? where MaSach = ?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,dto.getBookname());
            st.setInt(2,dto.getCategoryid());
            st.setInt(4,dto.getAuthorid());
            st.setInt(3,dto.getPublishid());
            st.setInt(5, dto.getPublishyear());
            st.setInt(6,dto.getQuantity());
             st.setInt(7, dto.getBookshelfid());
            st.setString(8,dto.getImage()); 
            st.setInt(9, dto.getBookid());
            result=st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
      return  result;
    }
    
    // xóa sách 
    public int deleteBook(BookDTO dto)
    {
        int result = -1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="update sach set TrangThai =0 where MaSach =?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, dto.getBookid());
            result=st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
        return result;
    }
    
    // lấy số lượng sách
    public static int getQuantityBook(int bookid)
    {
        int quantity=0;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="select SoLuong from sach where MaSach=? and TrangThai=1";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, bookid);
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {
                quantity=rs.getInt("SoLuong");
            }
        } catch (Exception e) {
        }finally{
            Data.closeconection(con);
        }
        return quantity;
    }
    
     
    // lấy tất cả các số lượng sách
    
    public int getAllQuantityAll()
    {
        int quantity=0;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="select SoLuong from sach  where TrangThai=1";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {
                quantity+=rs.getInt("SoLuong");
            }
        } catch (Exception e) {
        }finally{
            Data.closeconection(con);
        }
        return quantity;
    }
    //
   
}
