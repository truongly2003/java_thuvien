package BUS;

import DAL.BookShelfDAL;
import DTO.BookShelfDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BookShelfBUS {
    BookShelfDAL dal=new BookShelfDAL();
    public void showmess(String s)
    {
        JOptionPane.showMessageDialog(null, s);
    }
    // lấy hết
    public ArrayList<BookShelfDTO> getAllBookShelf()
    {
        return dal.getAll();
    }
    // thêm 
    public int insert(BookShelfDTO dto)
    {
        for(BookShelfDTO ke: getAllBookShelf()){
            if(ke.getLocation().equalsIgnoreCase(dto.getLocation()))
            {
                showmess("kệ đã tồn tại");
                return -1;
            }
        }
        if(dto.getLocation().trim().equals(""))
        {
            showmess("không được bỏ trống");
            return -1;
        }
        if(dal.insertBookShelf(dto)>0)
        {
            showmess("thêm thành công");
            return 1;
        }
        showmess(" thêm thất bại");
        return -1;
    }
    // sửa
    public int update(BookShelfDTO dto)
    {
        for(BookShelfDTO ke: getAllBookShelf()){
            if(ke.getLocation().equals(dto.getLocation()))
            {
                showmess("kệ đã tồn tại");
                return -1;
            }
        }
         if(dto.getLocation().trim().equals(""))
        {
            showmess("không được bỏ trống");
            return -1;
        }
         if(dal.updateBookSheltf(dto)>0)
         {
             showmess("sửa thành công");
         }
         showmess("sửa thất bại");
         return -1;
    }
    // xóa
    public int delete(BookShelfDTO dto)
    {
        if(dal.deleteSheltf(dto)>0)
        {
            showmess("xóa thành công");
            return 1;
        }
        showmess("xóa thất bại");
        return -1;
    }
    public static BookShelfBUS gI() {
        return new BookShelfBUS();
    }

}
