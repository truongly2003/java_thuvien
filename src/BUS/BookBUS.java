package BUS;
import DAL.BookDAL;
import DTO.BookDTO;
import GUI.BookGUI;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class BookBUS {
    BookDAL dao=new BookDAL();
    int current=LocalDate.now().getYear();
    public void showmess(String s) {
		JOptionPane.showMessageDialog(new BookGUI(), s);
	}
    // lấy hết sách
    public ArrayList<BookDTO> getAllBook()
    {
        return dao.getAllBook();
    }
    // thêm sách 
    public int insert(BookDTO dto)
    {
        if(dto.getBookname().matches(".*\\d+.*"))
        {
            showmess("tên sách sai");
            return -1;
        }
        if(dto.getPublishyear()>current || String.valueOf(dto.getPublishyear()).length()!=4 )
        {
            showmess("năm xuất bản sai");
            return -1;
        }
         if(dto.getQuantity()<=0 )
        {
            showmess("số lượng sách phải lớn hơn 0");
            return -1;
        }           
        if(dao.insertBook(dto)>0)
        {
            showmess("thêm sách thành công");
            return 1;
        }
        
        
        showmess("thêm sách thất bại");
        return -1;
    }
    // cập nhật 
   public int update(BookDTO dto)
    {
        if(dto.getBookname().matches(".*\\d+.*"))
        {
            showmess("tên sách sai");
            return -1;
        }
        if(dto.getPublishyear()>current  )
        {
            showmess("năm xuất bản sai");
            return -1;
        }
         if(dto.getQuantity()<=0 )
        {
            showmess("số lượng sách phải lớn hơn 0");
            return -1;
        }           
        if(dao.updateBook(dto)>0)
        {
            showmess("sửa sách thành công");
            return 1;
        }
        
        
        showmess("sửa sách thất bại");
        return -1;
    }
    // xóa 
    public int deleteBook(BookDTO dto)
    {
        if(dao.deleteBook(dto)>0)
        {
            showmess("xóa sách thành công");
            return 1;
        }
        showmess("xóa sách thất bại");
        return -1;
    }
    // tìm kiếm
    public BookDTO searchBook(int bookid)
    {
        return dao.searchBook(bookid);
    }
    //lấy số lượng sách
    public int getQuantityBook(int bookid)
    {
        return dao.getAllQuantityAll();
    }
    
//    public static BookBUS iBus = null;
//
//    public static BookBUS gI() {
//        if (iBus == null) {
//            iBus = new BookBUS();
//        }
//        return iBus;
//    }
    // tìm kiếm 
  


}
