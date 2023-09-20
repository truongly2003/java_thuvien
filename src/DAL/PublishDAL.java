package DAL;
import DTO.PublishDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class PublishDAL {
    // lấy hết nhà xuất bản
    public ArrayList<PublishDTO> getAllPublish()
    {
        ArrayList<PublishDTO> list=new ArrayList<>();
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="select * from nhaxuatban where TrangThai=1";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
               PublishDTO dto=new PublishDTO();
               dto.setPublishid(rs.getInt("MaNXB"));
               dto.setPublishname(rs.getString("TenNXB"));
               dto.setPhone(rs.getString("Sdt"));
               dto.setAddress(rs.getString("DiaChi"));
               list.add(dto);
            }
        } catch (Exception e) {
           
        }finally{
            Data.closeconection(con);
        }
        return list;
    }
    // thêm nhà xuất bản
    public int insertPublish(PublishDTO dto)
    {
        Connection con=null;
        int result=-1;
        try {
            con=Data.getconnection();
            String sql="insert into nhaxuatban (TenNXB,Sdt,DiaChi,TrangThai)"
                    + "values (?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, dto.getPublishname());
            st.setString(2, dto.getPhone());
            st.setString(3,dto.getAddress());
            st.setInt(4, 1);
            result=st.executeUpdate();
            
        } catch (Exception e) {
        }finally{
            Data.closeconection(con);
        }
        return result;
    }
    // sửa
    public int updateBPublish(PublishDTO dto)
    {
        int result=-1;
        Connection con=null;
        try {
            String sql="update nhaxuatban set TenNXB=?,Sdt=?,DiaChi=? where MaNXB=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, dto.getPublishname());
            st.setString(1, dto.getPhone());
            st.setString(3, dto.getAddress());
            st.setInt(4, dto.getPublishid());
            result=st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
      return  result;
    }
    // xóa nhà xuất bản
    public int deletePublish(PublishDTO dto)
    {
        int result = -1;
        Connection con=null;
        try {
            con=Data.getconnection();
            String sql="update nhaxuatban set trangthai =0 where MaNXB =?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, dto.getPublishid());
            result=st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(con);
        }
        return result;
    }
    // tìm nhà xuất bản
    public PublishDTO searchPublish(int publishid){   
        Connection con=null;
        PublishDTO dto =null;
        try {
            con=Data.getconnection();
            String sql="select * from nhaxuatban where MaNXB=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,publishid);
            ResultSet rs=st.executeQuery();
            
            while(rs.next())
            {
                dto=new PublishDTO();
                dto.setPublishid(rs.getInt("MaNXB"));
                dto.setPublishname(rs.getString("TenNXB"));
                dto.setAddress(rs.getString("DiaChi"));
                dto.setPhone(rs.getString("Sdt"));
               
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
