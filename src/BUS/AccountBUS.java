/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.ArrayList;
import DAL.AccountDAL;
import DTO.AccountDTO;
/**
 *
 * @author hoangtuan
 */
public class AccountBUS {

    private AccountDAL TAIKHOAN = new AccountDAL();
    private ArrayList<AccountDTO> listTAIKHOAN = new ArrayList<AccountDTO>();
    public ArrayList<AccountDTO> getDanhSachTL() {

        return TAIKHOAN.getdanhsachTK();
    }
}
