package BUS;
import DAL.BookCategoryDAL;
import DTO.BookCategoryDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BookCategoryBUS {
    BookCategoryDAL dal=new BookCategoryDAL();
    private ArrayList<BookCategoryDTO> catearr;
    public void showmess(String s)
    {
        JOptionPane.showMessageDialog(null, s);
    }
    // lấy hết
    public ArrayList<BookCategoryDTO> getAll()
    {
        return dal.getAllBookCategory();
    }
    // thêm
    public int insert(BookCategoryDTO dto)
    {
        if(dto.getCategoryName().trim().equals(""))
        {
            showmess("không được để trống tên loại");
            return -1;
        }
        for(BookCategoryDTO dto1 : getAll())
        {
            if(dto1.getCategoryName().equals(dto.getCategoryName()))
            {
                showmess("loại sách đã có");
                return -1;
            }
        }
        if(dal.insertBookCategory(dto)>0)
        {
            showmess("thêm thành công");
            return 1;
        }
        showmess("thêm thất bại");
        return -1;
    }
    // sửa
    public int update(BookCategoryDTO dto)
    {
        if(dto.getCategoryName().trim().equals(""))
        {
            showmess("không được để trống tên loại");
            return -1;
        }
        for(BookCategoryDTO dto1 : getAll())
        {
            if(dto1.getCategoryName().equals(dto.getCategoryName()))
            {
                showmess("loại sách đã có");
                return -1;
            }
        }
        if(dal.updateBookCategory(dto)>0)
        {
            showmess("sửa thành công");
            return 1;
        }
        showmess("sửa thất bại");
        return -1;
    }
    // xóa
    public int delete(BookCategoryDTO dto)
    {
        if(dal.deleteBookCategory(dto)>0)
        {
            showmess("xóa thành công");
            return 1;
        }
        showmess("xóa thất bại");
        return -1;
    }
    // lấy ra 1 loại
    public String getBookCategory(int id)
    {
        for(BookCategoryDTO book : dal.getAllBookCategory())
        {
            if(book.getCategoryid()==id){
                return book.getCategoryid() + "-" +book.getCategoryName();
            }
        }
        return null;
    } 
    public static BookCategoryBUS gI()
    {
        return new BookCategoryBUS();
    }
    public int getBookCategoryid(int categoryid)
    {
        for(BookCategoryDTO dtoo: dal.getAllBookCategory())
        {
            if(dtoo.getCategoryid()==categoryid)
            {
                return dtoo.getCategoryid();
            }
        }
        return 0;
    }
}
