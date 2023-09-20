package BUS;
import DAL.PublishDAL;
import DTO.PublishDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class PublishBUS {
    PublishDAL dal=new PublishDAL();
    public void showmess(String s)
    {
        JOptionPane.showMessageDialog(null, s);
    }
    // lấy hết
    public ArrayList<PublishDTO> getAllPublish()
    {
        return dal.getAllPublish();
    }
    // thêm
    public int insertPublish(PublishDTO dto)
    {
        if(dto.getPublishname().trim().equals(""))
        {
            showmess("không được để trống tên nhà xuất bản");
            return -1;
        }
        if(dto.getPublishname().matches(".*\\d+.*"))
        {
            showmess("nhà xuất bản sai");
            return -1;
        }
        if(dto.getAddress().trim().equals(""))
        {
            showmess("không được để trống địa chỉ");
            return -1;
        }
        if(dto.getAddress().matches(".*\\d+.*"))
        {
            showmess("địa chỉ sai");
            return -1;
        }
        if(dto.getPhone().trim().equals(""))
        {
            showmess("không để trống số điện thoại");
            return -1;
        }
        if(!dto.getPhone().matches(".*\\d+.*")|| dto.getPhone().length()!=10)
        {
            showmess("số điện thoại sai");
            return -1;
        }
        if(dal.insertPublish(dto)>0)
        {
            showmess("thêm thành công");
            return 1;
        }
        showmess("thêm thất bại");
        return -1;
    }
    // sửa
     public int update(PublishDTO dto)
    {
        if(dto.getPublishname().trim().equals(""))
        {
            showmess("không được để trống tên nhà xuất bản");
            return -1;
        }
        if(dto.getPublishname().matches(".*\\d+.*"))
        {
            showmess("nhà xuất bản sai");
            return -1;
        }
        if(dto.getAddress().trim().equals(""))
        {
            showmess("không được để trống địa chỉ");
            return -1;
        }
        if(dto.getAddress().matches(".*\\d+.*"))
        {
            showmess("địa chỉ sai");
            return -1;
        }
        if(dto.getPhone().trim().equals(""))
        {
            showmess("không để trống số điện thoại");
            return -1;
        }
        if(!dto.getPhone().matches(".*\\d+.*")|| dto.getPhone().length()!=10)
        {
            showmess("số điện thoại sai");
            return -1;
        }
        if(dal.updateBPublish(dto)>0)
        {
            showmess("sửa thành công");
            return 1;
        }
        showmess("sửa thất bại");
        return -1;
    }
     // xóa
     public int delete(PublishDTO dto)
     {
         if(dal.deletePublish(dto)>0)
         {
             showmess("xóa thành công");
             return 1;
         }
         showmess("xóa thất bại");
         return -1;
     }
     public PublishDTO search(int publishid)
     {
         return dal.searchPublish(publishid);
     }
     
     public static PublishBUS iBus = null;

    public static PublishBUS  gI() {
        if (iBus == null) {
            iBus = new PublishBUS();
        }

        return iBus;
    }
}
