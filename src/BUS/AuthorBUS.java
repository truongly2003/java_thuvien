package BUS;
import DAL.AuthorDAL;
import DTO.AuthorDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class AuthorBUS {
    AuthorDAL dao=new AuthorDAL();
    int current=LocalDate.now().getYear();
    public void showmess(String s)
    {
        JOptionPane.showMessageDialog(null, s);
    }
    // lấy hết
    public ArrayList<AuthorDTO> getAll()
    {
       return dao.getAllAuthor();
    }
    // thêm
    public  int insertAuthor(AuthorDTO dto)
    {
       
        if(dto.getAuthorname().trim().equals(""))
        {
            showmess("không được để trống tên tác giả");
            return -1;
        }
        if(dto.getAuthorname().matches(".*\\d+.*"))
        {
            showmess("tên tác giả sai");
            return -1;
        }
        // 1111
        if( dto.getBirth()>current || String.valueOf(dto.getBirth()).length()!=4 )
        {
            showmess("năm sinh sai");
            return -1;
        } 
        
        if(dto.getHometown().trim().equals(""))
        {
            showmess("không được để trống quê quán");
            return -1;
        }
         if(dto.getHometown().matches(".*\\d+.*"))
        {
            showmess("quê quán sai");
            return -1;
        }
        
        if(dao.insertAuthor(dto)>0)
        {
            showmess("thêm tác giả thành công");
            return 1;
        }
        showmess("thêm thất bại");
        return -1;
    }
    // sửa
    public int update(AuthorDTO dto)
    {
        if(dto.getAuthorname().trim().equals(""))
        {
            showmess("không được để trống tên tác giả");
            return -1;
        }
        if(dto.getAuthorname().matches(".*\\d+.*"))
        {
            showmess("tên tác giả sai");
            return -1;
        }
        // 1111
        if( dto.getBirth()>current || String.valueOf(dto.getBirth()).length()!=4 )
        {
            showmess("năm sinh sai");
            return -1;
        } 
        
        if(dto.getHometown().trim().equals(""))
        {
            showmess("không được để trống quê quán");
            return -1;
        }
         if(dto.getHometown().matches(".*\\d+.*"))
        {
            showmess("quê quán sai");
            return -1;
        }
        
        if(dao.updateAuthor(dto)>0)
        {
            showmess("sửa tác giả thành công");
            return 1;
        }
        showmess("sửa thất bại");
        return -1;
    }
    // xóa
    public int delete(AuthorDTO dto)
    {
        if(dao.deleteAuthor(dto)>0)
        {
            showmess("xóa tác giả thành công");
            return 1;
        }
        showmess("xóa sách thất bại");
        return -1;
    }
    // tìm kiếm 
    public AuthorDTO search(int authorid)
    {     
        return dao.searchAuthor(authorid);
        
    }
    
    public static AuthorBUS iBus = null;

    public static AuthorBUS gI() {
        if (iBus == null) {
            iBus = new AuthorBUS();
        }

        return iBus;
    }
}
