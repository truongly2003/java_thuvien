package DAL;
import DTO.BookCategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class BookCategoryDAL {
    // danh sách loại sách
    public ArrayList<BookCategoryDTO> getAllBookCategory()
    {
        ArrayList<BookCategoryDTO> list=new ArrayList<>();
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="select * from loai where TrangThai=1";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
               BookCategoryDTO dto=new BookCategoryDTO();
               dto.setCategoryid(rs.getInt("MaLoai"));
               dto.setCategoryName(rs.getString("TenLoai"));
               list.add(dto);
            }
        } catch (Exception e) {
            return null;
        }finally{
            Data.closeconection(con);
        }
        return list;
    }
    //thêm loại sách
    public int  insertBookCategory(BookCategoryDTO dto)
    {
        int result=-1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="insert into loai (TenLoai,TrangThai)"
                    + "values (?,?)";     
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, dto.getCategoryName());
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
    // sửa
     public int updateBookCategory(BookCategoryDTO dto)
    {
        int result = -1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="update loai set TenLoai=? where MaLoai=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, dto.getCategoryName());
            st.setInt(2, dto.getCategoryid());
            result=st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
        return result;
    }
    // xóa loại sách
     public int deleteBookCategory(BookCategoryDTO dto)
    {
        int result = -1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="update loai set TrangThai=? where MaLoai=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, 0);
            st.setInt(2, dto.getCategoryid());
            result=st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
        return result;
    } 
}
