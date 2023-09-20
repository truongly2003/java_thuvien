package DAL;
import DTO.AuthorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class AuthorDAL {
    
    // danh sách tác giả
    public ArrayList<AuthorDTO> getAllAuthor()
    {
        
        ArrayList<AuthorDTO> list=new ArrayList<>();
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="select * from tacgia where TrangThai=1";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
               AuthorDTO dto=new AuthorDTO();
               dto.setAuthorid(rs.getInt(1));
               dto.setAuthorname(rs.getString("TenTacGia"));
               dto.setBirth(rs.getInt("NamSinh"));
               dto.setHometown(rs.getString("QueQuan"));
               list.add(dto);
            }
        } catch (Exception e) {
           
        }finally{
            Data.closeconection(con);
        }
        return list;
    }
    // thêm tác giả
    public int insertAuthor(AuthorDTO dto)
    {
        int result=-1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="insert into tacgia (TenTacGia,NamSinh,QueQuan,TrangThai)"
                    + " values(?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, dto.getAuthorname());
            st.setInt(2, dto.getBirth());
            st.setString(3, dto.getHometown());
            st.setInt(4, 1);
            result=st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Data.closeconection(con);
        }
       
        return result;
    }
    // cập nhật tác giả
     public int updateAuthor(AuthorDTO dto)
    {
        int result = -1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="update tacgia set TenTacGia=?, NamSinh=?,QueQuan=? where MaTacGia=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, dto.getAuthorname());
            st.setInt(2, dto.getBirth());
            st.setString(3, dto.getHometown());
            st.setInt(4, dto.getAuthorid());
            result=st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
        return result;
    }
    // xóa tác giả
      public int deleteAuthor(AuthorDTO dto)
    {
        int result = -1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="update tacgia set TrangThai=0 where MaTacGia=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, dto.getAuthorid());
            result=st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
        return result;
    }
    // tìm tác giả
    public AuthorDTO searchAuthor(int authorid){
        Connection con=null;
        AuthorDTO dto=null;
        try {
            con=Data.getconnection();
            String sql="select * from tacgia where MaTacGia=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,authorid);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                dto=new AuthorDTO();
                dto.setAuthorid(rs.getInt("MaTacGia"));
                dto.setAuthorname(rs.getString("TenTacGia"));
                dto.setHometown(rs.getString("QueQuan"));
                dto.setBirth(rs.getInt("NamSinh"));
            }
            return dto;
            
        } catch (Exception e) {
             e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
      return null;
    }
    
    
}
