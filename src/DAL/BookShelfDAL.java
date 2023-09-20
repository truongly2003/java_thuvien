package DAL;
import DTO.BookShelfDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class BookShelfDAL {
    // lấy hết kệ sách
    public ArrayList<BookShelfDTO> getAll()
    {
        ArrayList<BookShelfDTO> list=new ArrayList<>();
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="select * from kesach where TrangThai=1";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                BookShelfDTO dto=new BookShelfDTO();
                dto.setBookshelfid(rs.getInt("MaKe"));
                dto.setLocation(rs.getString("ViTri"));
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
    // thêm kệ sách
    public int insertBookShelf(BookShelfDTO dto)
    {
        int result=-1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="insert into kesach (ViTri,TrangThai)"
                    + "values (?,?)";     
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, dto.getLocation());
            st.setInt(2, 1);
            result=st.executeUpdate();
            Data.closeconection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
        return result;
    }
    // sửa kệ sách
    public int updateBookSheltf(BookShelfDTO dto)
    {
        int result=-1;
        Connection con=null;
        try {
            String sql="update kesach set ViTri =? where MaKe=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,dto.getLocation());
            st.setInt(2, dto.getBookshelfid());
            result=st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
      return  result;
    }
    // xóa kệ sách
    public int deleteSheltf(BookShelfDTO dto)
    {
        int result = 0;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="update kesach set TrangThai =? where MaKe =?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, 0);
            st.setInt(2, dto.getBookshelfid());
            result=st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
        return result;
    }
}
